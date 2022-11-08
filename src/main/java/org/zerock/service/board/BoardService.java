package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;
import org.zerock.mapper.board.ReplyMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private ReplyMapper replyMapper;

	public int register(BoardDto board) {
		return boardMapper.insert(board);
	}
	
	public int update(BoardDto board) {
		return boardMapper.update(board);
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
	
	@Transactional
	public int remove(int id) {
		// 게시물 댓글들 지우기
		replyMapper.deleteByBoardId(id);
		
		// int a = 3 / 0;  // runtime exception
		
		// 게시물 지우기
		return boardMapper.delete(id);
	}
	

}
