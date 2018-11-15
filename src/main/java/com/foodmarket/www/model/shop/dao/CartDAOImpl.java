package com.foodmarket.www.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodmarket.www.model.shop.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertCart(CartDTO dto) {
		sqlSession.insert("cart.insertCart", dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		return sqlSession.selectList("cart.listCart", userid);
	}

	@Override
	public int sumMoney(String userid) {
		return sqlSession.selectOne("cart.sumMoney", userid);
	}

	@Override
	public void deleteCart(int cart_id) {
		sqlSession.update("cart.deleteCart", cart_id);
	}

	@Override
	public void deleteAllCart(String userid) {
		sqlSession.delete("cart.deleteAllCart", userid);
	}

	@Override
	public void updateCart(CartDTO dto) {
		sqlSession.update("cart.updateCart", dto);
	}

}
