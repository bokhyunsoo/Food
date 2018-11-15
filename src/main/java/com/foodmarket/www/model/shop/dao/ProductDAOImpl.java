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
	public List<ProductDTO> listSkewer() {
		Map<String,Object> map = new HashMap<>();
		return sqlSession.selectList("product.listSkewer", map);
	}

	@Override
	public List<ProductDTO> listDog() {
		Map<String,Object> map = new HashMap<>();
		return sqlSession.selectList("product.listDog", map);
	}

	@Override
	public List<ProductDTO> listSausage() {
		Map<String,Object> map = new HashMap<>();
		return sqlSession.selectList("product.listSausage", map);
	}

}
