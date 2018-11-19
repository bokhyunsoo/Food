package com.foodmarket.www.model.board.dao;

import java.util.List;

import com.foodmarket.www.model.board.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> boardList(int start, int end);
	public int boardCount();
}
