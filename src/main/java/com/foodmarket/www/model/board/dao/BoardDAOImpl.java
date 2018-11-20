package com.foodmarket.www.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodmarket.www.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> boardList(int start, int end) {
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("board.listAll", map);
	}

	@Override
	public int boardCount() {
		return sqlSession.selectOne("board.count");
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		sqlSession.insert("board.insertBoard", dto);
	}

}
