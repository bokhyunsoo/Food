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
	public List<ProductDTO> listSkewer(int start, int end) {
		return productDao.listSkewer(start, end);
	}

	@Override
	public List<ProductDTO> listDog(int start, int end) {
		return productDao.listDog(start, end);
	}

	@Override
	public List<ProductDTO> listSausage(int start, int end) {
		return productDao.listSausage(start, end);
	}

	@Override
	public int countSkewer() {
		return productDao.countSkewer();
	}

	@Override
	public int countDog() {
		return productDao.countDog();
	}

	@Override
	public int countSausage() {
		return productDao.countSausage();
	}

	@Override
	public ProductDTO productDetail(int product_id) {
		return productDao.productDetail(product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		productDao.insertProduct(dto);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		productDao.updateProduct(dto);
	}

}
