package com.foodmarket.www.model.shop.dao;

import java.util.List;

import com.foodmarket.www.model.shop.dto.ProductDTO;

public interface ProductDAO {
	public List<ProductDTO> listSkewer(int start, int end);
	public List<ProductDTO> listDog(int start, int end);
	public List<ProductDTO> listSausage(int start, int end);
	public int countSkewer();
	public int countDog();
	public int countSausage();
	public ProductDTO productDetail(int product_id);
	public void insertProduct(ProductDTO dto);
	public void updateProduct(ProductDTO dto);
	public String fileInfo(int product_id);
	public String descriptionInfo(int product_id);
	public void deleteProduct(int product_id);
}
