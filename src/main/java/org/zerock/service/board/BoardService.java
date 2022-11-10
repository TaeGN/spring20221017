package org.zerock.service.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;
import org.zerock.mapper.board.ReplyMapper;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Autowired
	private S3Client s3Client;
	
	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	public int update(BoardDto board, MultipartFile[] addFiles, List<String> removeFiles) {
		int boardId = board.getId();
		
		// removeFiles 에 있는 파일명으로 
		if(removeFiles != null) {
			for (String fileName : removeFiles) {
				// 1. File 테이블에서 record 지우기
				boardMapper.deleteFileByBoardIdAndFileName(boardId, fileName);
				// 2. 저장소에 실제 파일 지우기
				String path = "C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + boardId + "\\" + fileName;
				File file = new File(path);
				
				file.delete();
			}
		}
			
		
		for (MultipartFile file : addFiles) {
			if (file != null && file.getSize() > 0) {
				String name = file.getOriginalFilename();
				// File table에 해당파일명 지우기
				boardMapper.deleteFileByBoardIdAndFileName(boardId, name);
				
				// File table에 파일명 추가
				boardMapper.insertFile(boardId, name);
				
				// 저장소에 실제 파일 추가
				File folder = new File("C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + board.getId());
				folder.mkdirs();
				
				File dest = new File(folder, name);
				
				try {
					file.transferTo(dest);
				} catch (Exception e) {
					// @Transactional은 RuntimeException에서만 rollback 됨
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			
		}				
				
				
		
		
		return boardMapper.update(board);
	}
	
	public int register(BoardDto board, MultipartFile[] files) {
		// db에 게시물 정보 저장
		int cnt = boardMapper.insert(board);
				
		for (MultipartFile file : files) {
			if (file != null && file.getSize() > 0) {
				// db에 파일 정보 저장
				boardMapper.insertFile(board.getId(), file.getOriginalFilename());
				
				try {
					// S3에 파일 저장
					// 키 생성
					String key = "prj1/board/" + board.getId() + "/" + file.getOriginalFilename();
					
					// putObjectRequest
					PutObjectRequest putObjectRequest = PutObjectRequest.builder()
							.bucket(bucketName)
							.key(key)
							.acl(ObjectCannedACL.PUBLIC_READ)
							.build();
					
					// requestBody
					RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
					
					// object(파일) 올리기
					s3Client.putObject(putObjectRequest, requestBody);
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
				
		return cnt;
	}
	
	
	public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
		int records = 10;
		int offset = (page - 1) * records ;
		
		int countAll = boardMapper.countAll(type, "%" + keyword + "%"); // SELECT Count(*) FROM Board
		int lastPageNumber = (countAll - 1) / records + 1;
		
		int leftPageNumber = (page - 1) / 10 * 10 + 1;
		int rightPageNumber = leftPageNumber + 9;
		rightPageNumber = (int) Math.min(lastPageNumber, rightPageNumber);
		
		// 이전버튼 유무
		boolean hasPrevButton = page > 10;
		// 다음버튼 유무
		boolean hasNextButton = page <= (lastPageNumber - 1) / 10 * 10;
		
		// 이전버튼 눌렀을 떄 가는 페이지 번호
		int jumpPrevPageNumber = (page - 1) / 10 * 10 - 9;
		int jumpNextPageNumber = (page - 1) / 10 * 10 + 11;
		
		
		pageInfo.setHasNextButton(hasNextButton);
		pageInfo.setHasPrevButton(hasPrevButton);
		pageInfo.setJumpNextPageNumber(jumpNextPageNumber);
		pageInfo.setJumpPrevPageNumber(jumpPrevPageNumber);
		
		pageInfo.setCurrentPageNumber(page);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		pageInfo.setLastPageNumber(lastPageNumber);
		
		return boardMapper.list(offset, records, type, "%" + keyword + "%");
	}

	public BoardDto get(int id) {
		return boardMapper.select(id);
	}
	
	public int remove(int id) {
		BoardDto board = boardMapper.select(id);
		
		List<String> fileNames = board.getFileName();
		if(fileNames != null) {
			for(String fileName : fileNames) {
				// S3 저장소의 파일지우기
				String key = "prj1/board/" + id + "/" + fileName;
				DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
						.bucket(bucketName)
						.key(key)
						.build();
				s3Client.deleteObject(deleteObjectRequest);
			}
		}
		
		// db 파일 records 지우기
		boardMapper.deleteFileByBoardId(id);
		
		// 게시물 댓글들 지우기
		replyMapper.deleteByBoardId(id);
		
		// int a = 3 / 0;  // runtime exception
		
		// 게시물 지우기
		return boardMapper.delete(id);
	}
	

}
