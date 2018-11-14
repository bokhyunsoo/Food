package com.foodmarket.www.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodmarket.www.model.member.dto.MemberDTO;
import com.foodmarket.www.service.member.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {

	@Inject
	MemberService memberService;
	
	@RequestMapping("join.do")
	public String joinForm() {
		return "member/join";
	}
	
	@RequestMapping("insert.do")
	public ModelAndView join(MemberDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		memberService.join(dto);
		mav.addObject("message", "success");
		mav.setViewName("member/login");
		return mav;
		
	}
	
	@RequestMapping("login.do")
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login(MemberDTO dto, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String name = memberService.LoginCheck(dto);
		
		if(name != null) {
			session.setAttribute("userid", dto.getUserId());
			session.setAttribute("name", name);
			mav.setViewName("redirect:/");
		} else {
			mav.addObject("message", "error");
			mav.setViewName("member/login");
		}
		
		return mav;
	}
}
