package com.foodmarket.www.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodmarket.www.model.admin.dao.AdminDAO;
import com.foodmarket.www.model.member.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	AdminDAO adminDao;

	@Override
	public String login(MemberDTO dto) {
		return adminDao.login(dto);
	}

}
