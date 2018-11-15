package com.foodmarket.www.controller.shop;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodmarket.www.model.shop.dto.Pager;
import com.foodmarket.www.service.shop.ProductService;

@Controller
@RequestMapping("shop/product/*")
public class ProductController {

	@Inject
	ProductService productService;
	
	@RequestMapping("doglist.do")
	public ModelAndView listDog(@RequestParam(defaultValue="1") int curPage) {
		ModelAndView mav = new ModelAndView();
		int countDog = productService.countDog();
		Pager pager = new Pager(countDog,curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		Map<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		mav.addObject("map", map);
		mav.addObject("dog", productService.listDog(start, end));
		mav.setViewName("shop/listDog");
		return mav;
	}
	
	@RequestMapping("skewerlist.do")
	public ModelAndView listSkewer(@RequestParam(defaultValue="1") int curPage) {
		ModelAndView mav = new ModelAndView();
		int countSkewer = productService.countSkewer();
		Pager pager = new Pager(countSkewer,curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		Map<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		mav.addObject("map", map);
		mav.addObject("skewer", productService.listSkewer(start, end));
		mav.setViewName("shop/listSkewer");
		return mav;
	}
	
	@RequestMapping("sausagelist.do")
	public ModelAndView listSausage(@RequestParam(defaultValue="1") int curPage) {
		ModelAndView mav = new ModelAndView();
		int countSkewer = productService.countSausage();
		Pager pager = new Pager(countSkewer,curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		Map<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		mav.addObject("map", map);
		mav.addObject("sausage", productService.listSausage(start, end));
		mav.setViewName("shop/listSausage");
		return mav;
	}
	
}
