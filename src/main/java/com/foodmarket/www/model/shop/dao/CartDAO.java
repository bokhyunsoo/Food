package com.foodmarket.www.model.shop.dao;

import java.util.List;

import com.foodmarket.www.model.shop.dto.CartDTO;

public interface CartDAO {
	public void insertCart(CartDTO dto);
	public List<CartDTO> listCart(String userid);
	public int sumMoney(String userid);
}
