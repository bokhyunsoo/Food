package com.foodmarket.www.model.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodmarket.www.model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> listSkewer(int start, int end) {
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("product.listSkewer", map);
	}

	@Override
	public List<ProductDTO> listDog(int start, int end) {
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("product.listDog", map);
	}

	@Override
	public List<ProductDTO> listSausage(int start, int end) {
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("product.listSausage", map);
	}

	@Override
	public int countSkewer() {
		return sqlSession.selectOne("product.countSkewer");
	}

	@Override
	public int countDog() {
		return sqlSession.selectOne("product.countDog");
	}

	@Override
	public int countSausage() {
		return sqlSession.selectOne("product.countSausage");
	}

	@Override
	public ProductDTO productDetail(int product_id) {
		return sqlSession.selectOne("product.productDetail", product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("product.insertProduct", dto);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		sqlSession.update("product.updateProduct", dto);
	}

	@Override
	public String fileInfo(int product_id) {
		return sqlSession.selectOne("product.fileInfo", product_id);
	}

	@Override
	public String descriptionInfo(int product_id) {
		return sqlSession.selectOne("product.descriptionInfo", product_id);
	}

	@Override
	public void deleteProduct(int product_id) {
		sqlSession.delete("product.deleteProduct", product_id);
	}

}
