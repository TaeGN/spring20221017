package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
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

	public List<BoardDto> listBoard() {
		return mapper.list();
	}

	public BoardDto get(int id) {
		return mapper.select(id);
	}

	public int remove(int id) {
		return mapper.delete(id);
	}

}
