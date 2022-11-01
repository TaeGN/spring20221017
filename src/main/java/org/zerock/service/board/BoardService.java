package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;

	public int register(BoardDto board) {
		return mapper.insert(board);
	}
	
	public int update(BoardDto board) {
		return mapper.update(board);
	}

	public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
		int records = 10;
		int offset = (page - 1) * records ;
		
		int countAll = mapper.countAll(type, "%" + keyword + "%"); // SELECT Count(*) FROM Board
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
		
		return mapper.list(offset, records, type, "%" + keyword + "%");
	}

	public BoardDto get(int id) {
		return mapper.select(id);
	}

	public int remove(int id) {
		return mapper.delete(id);
	}

}
