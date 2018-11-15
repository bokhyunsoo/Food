package com.foodmarket.www.service.shop;

import java.util.List;

import com.foodmarket.www.model.shop.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> listSkewer(int start, int end);
	public List<ProductDTO> listDog(int start, int end);
	public List<ProductDTO> listSausage(int start, int end);
	public int countSkewer();
	public int countDog();
	public int countSausage();
}
