package com.foodmarket.www.service.shop;

import java.util.List;

import com.foodmarket.www.model.shop.dto.CartDTO;

public interface CartService {
	public void insertCart(CartDTO dto);
	public List<CartDTO> listCart(String userid);
	public int sumMoney(String userid);
}
