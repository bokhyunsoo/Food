package com.foodmarket.www.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodmarket.www.model.shop.dao.ProductDAO;
import com.foodmarket.www.model.shop.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO productDao;
	
	@Override
	public List<ProductDTO> listSkewer() {
		return productDao.listSkewer();
	}

	@Override
	public List<ProductDTO> listDog() {
		return productDao.listDog();
	}

	@Override
	public List<ProductDTO> listSausage() {
		return productDao.listSausage();
	}

}
