package com.foodmarket.www.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodmarket.www.model.board.dao.BoardDAO;
import com.foodmarket.www.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> boardList(int start, int end) {
		return boardDao.boardList(start, end);
	}

	@Override
	public int boardCount() {
		return boardDao.boardCount();
	}

}
