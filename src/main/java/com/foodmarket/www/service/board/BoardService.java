package com.foodmarket.www.service.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.foodmarket.www.model.board.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardList(int start, int end);
	public int boardCount();
	public void insertBoard(BoardDTO dto);
	public BoardDTO detailBoard(int bno);
	public void increaseViewcnt(int bno, HttpSession session) throws Exception; // 조회수 증가
	public void updateBoard(BoardDTO dto);
	public void deleteBoard(int bno);
}
