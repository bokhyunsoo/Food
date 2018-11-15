package com.foodmarket.www.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodmarket.www.model.shop.dto.CartDTO;
import com.foodmarket.www.service.shop.CartService;

@Controller
@RequestMapping("shop/cart/*")
public class CartController {

	@Inject
	CartService cartService;
	
	@RequestMapping("insert.do")
	public String insertCart(CartDTO dto, HttpSession session) {
		
		String userid = (String) session.getAttribute("userid");
		dto.setUserId(userid);
		cartService.insertCart(dto);
		return "redirect:/shop/cart/listCart.do";
	}
	
	@RequestMapping("listCart.do")
	public ModelAndView listCart(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = new HashMap<>();
		String userid = (String) session.getAttribute("userid");
		
		int sumMoney = cartService.sumMoney(userid);
		int fee = sumMoney >= 30000 ? 0 : 2500;
		
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("sum", sumMoney+fee);
		
		if(userid != null) {
			List<CartDTO> cartList = cartService.listCart(userid);
			map.put("count", cartList.size());
			map.put("list", cartList);
			mav.addObject("map", map);
			mav.setViewName("shop/cart_list");
			return mav;
		} else {
			mav.addObject("message", "nologin");
			mav.setViewName("member/login");
			return mav;
		}
	}
	
	@RequestMapping("delete.do")
	public String deleteCart(@RequestParam int cart_id) {
		cartService.deleteCart(cart_id);
		return "redirect:/shop/cart/listCart.do";
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAllCart(HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		cartService.deleteAllCart(userid);
		return "redirect:/shop/cart/listCart.do";
	}
	
}
