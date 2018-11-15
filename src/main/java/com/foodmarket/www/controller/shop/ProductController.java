package com.foodmarket.www.controller.shop;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodmarket.www.service.shop.ProductService;

@Controller
@RequestMapping("shop/product/*")
public class ProductController {

	@Inject
	ProductService productService;
	
	@RequestMapping("doglist.do")
	public ModelAndView listDog() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dog", productService.listDog());
		mav.setViewName("shop/listDog");
		return mav;
	}
	
	@RequestMapping("skewerlist.do")
	public ModelAndView listSkewer() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("skewer", productService.listSkewer());
		mav.setViewName("shop/listSkewer");
		return mav;
	}
	
	@RequestMapping("sausagelist.do")
	public ModelAndView listSausage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sausage", productService.listSausage());
		mav.setViewName("shop/listSausage");
		return mav;
	}
	
}
