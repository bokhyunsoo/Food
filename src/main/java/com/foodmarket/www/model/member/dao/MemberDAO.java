package com.foodmarket.www.model.member.dao;

import com.foodmarket.www.model.member.dto.MemberDTO;

public interface MemberDAO {
	public void Join(MemberDTO dto);
	public String LoginCheck(MemberDTO dto);
}
