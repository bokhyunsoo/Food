package com.foodmarket.www.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodmarket.www.model.member.dto.MemberDTO;
import com.foodmarket.www.service.admin.AdminService;

@Controller
@RequestMapping("admin/*")
public class AdminController {

	@Inject
	AdminService adminService;
	
	@RequestMapping("login.do")
	public String loginForm() {
		return "admin/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView loginAdmin(MemberDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String name = adminService.login(dto);
		
		if(name != null) {
			session.setAttribute("admin_name", name);
			session.setAttribute("admin_userid", dto.getUserId());
			mav.addObject("message", "success");
			mav.setViewName("admin/admin");
		} else {
			mav.addObject("message", "error");
			mav.setViewName("admin/login");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public String logoutAdmin(HttpSession session) {
		session.removeAttribute("admin_name");
		session.removeAttribute("admin_userid");
		return "home";
	}
}
