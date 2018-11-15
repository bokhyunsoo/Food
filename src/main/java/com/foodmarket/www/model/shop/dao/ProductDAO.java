package com.foodmarket.www.model.shop.dao;

import java.util.List;

import com.foodmarket.www.model.shop.dto.ProductDTO;

public interface ProductDAO {
	public List<ProductDTO> listSkewer();
	public List<ProductDTO> listDog();
	public List<ProductDTO> listSausage();
}
