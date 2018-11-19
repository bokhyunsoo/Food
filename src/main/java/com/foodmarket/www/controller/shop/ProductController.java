package com.foodmarket.www.controller.shop;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodmarket.www.model.shop.dto.Pager;
import com.foodmarket.www.model.shop.dto.ProductDTO;
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
	
	@RequestMapping("detail/{product_id}")
	public ModelAndView productDetail(@PathVariable int product_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("detail", productService.productDetail(product_id));
		mav.setViewName("shop/product_detail");
		return mav;
	}
	
	@RequestMapping("dogwrite.do")
	public String dogWrite() {
		return "shop/dog_write";
	}
	
	@RequestMapping("skewerwrite.do")
	public String skewerWrite() {
		return "shop/skewer_write";
	}
	
	@RequestMapping("sausagewrite.do")
	public String sausageWrite() {
		return "shop/sausage_write";
	}
	
	@RequestMapping(value= {"skewerinsert.do", "doginsert.do", "sausageinsert.do"})
	public String insert(@ModelAttribute ProductDTO dto, @RequestParam int v) {
		String desciption_filename = "-";
		String picture_filename = "-";
		if (!dto.getDescription_file().isEmpty() || !dto.getPicture_file().isEmpty()) {
			desciption_filename = dto.getDescription_file().getOriginalFilename();
			picture_filename = dto.getPicture_file().getOriginalFilename();
			
			try {
				String path = "D:\\Spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FoodMarket\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				// 업로드된 임시파일을 원하는 디렉토리로 복사
				dto.getDescription_file().transferTo(new File(path + desciption_filename));
				dto.getPicture_file().transferTo(new File(path + picture_filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setDescription(desciption_filename);
		dto.setPicture_url(picture_filename);
		
		// 상품정보를 레코드에 저장
		productService.insertProduct(dto);
		// 상품 목록 페이지로 이동
				
		System.out.println(dto);
//				System.out.println("여기 잘보자:"+value);
				
		if(v == 1) {
			return "redirect:/shop/product/doglist.do";	
		} else if(v == 0) {
			return "redirect:/shop/product/skewerlist.do";
		} else {
			return "redirect:/shop/product/sausagelist.do";
		}
	}
	
	
	
}
