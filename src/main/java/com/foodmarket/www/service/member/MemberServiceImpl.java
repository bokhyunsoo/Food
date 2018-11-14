package com.foodmarket.www.service.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodmarket.www.model.member.dao.MemberDAO;
import com.foodmarket.www.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public void join(MemberDTO dto) {
		memberDao.Join(dto);
	}

}
