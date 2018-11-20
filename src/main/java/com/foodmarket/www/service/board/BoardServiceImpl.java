package com.foodmarket.www.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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

	@Override
	public void insertBoard(BoardDTO dto) {
		boardDao.insertBoard(dto);
	}

	@Override
	public BoardDTO detailBoard(int bno) {
		return boardDao.detailBoard(bno);
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		// 세션에 저장된 게시물의 조회시간 검색
		
		if(session.getAttribute("update_time_"+bno)!=null) {
			update_time = (long) session.getAttribute("update_time_"+bno);
		}
		// 현재 시간
		long current_time = System.currentTimeMillis();
		// 일정 시간이 경과된 후 조회수 증가 처리
		if (current_time - update_time > 10*1000 ) {
			boardDao.increaseViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		boardDao.updateBoard(dto);
	}

	@Override
	public void deleteBoard(int bno) {
		boardDao.deleteBoard(bno);
	}

}
