package com.foodmarket.www.model.board.dao;

import java.util.List;

import com.foodmarket.www.model.board.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> boardList(int start, int end);
	public int boardCount();
	public void insertBoard(BoardDTO dto);
	public BoardDTO detailBoard(int bno);
	public void increaseViewcnt(int bno); // 조회수 증가
	public void updateBoard(BoardDTO dto);
	public void deleteBoard(int bno);
}
