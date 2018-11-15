package com.foodmarket.www.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodmarket.www.model.shop.dao.CartDAO;
import com.foodmarket.www.model.shop.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Inject
	CartDAO cartDao;
	
	@Override
	public void insertCart(CartDTO dto) {
		cartDao.insertCart(dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		return cartDao.listCart(userid);
	}

	@Override
	public int sumMoney(String userid) {
		return cartDao.sumMoney(userid);
	}

}
