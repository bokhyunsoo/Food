package com.foodmarket.www.model.admin.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodmarket.www.model.member.dto.MemberDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public String login(MemberDTO dto) {
		return sqlSession.selectOne("admin.loginAdmin", dto);
	}
	
}
