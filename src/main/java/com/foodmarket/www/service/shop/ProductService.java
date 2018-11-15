package com.foodmarket.www.service.shop;

import java.util.List;

import com.foodmarket.www.model.shop.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> listSkewer();
	public List<ProductDTO> listDog();
	public List<ProductDTO> listSausage();
}
