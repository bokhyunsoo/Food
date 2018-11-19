package com.foodmarket.www.service.board;

import java.util.List;

import com.foodmarket.www.model.board.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardList(int start, int end);
	public int boardCount();
}
