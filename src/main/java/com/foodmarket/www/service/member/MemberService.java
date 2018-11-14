package com.foodmarket.www.service.member;

import com.foodmarket.www.model.member.dto.MemberDTO;

public interface MemberService {
	public void join(MemberDTO dto);
	public String LoginCheck(MemberDTO dto);
}
