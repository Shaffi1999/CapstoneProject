package com.smartshop.registerationandlogin.service;

import java.util.List;

import com.smartshop.registerationandlogin.entity.CartItem;
import com.smartshop.registerationandlogin.model.Product;

public interface ICartService {
	 //public List<CartItem> addToCart(List<CartItem> cartItemsNew);
	 public long calculatePrice(Integer userId);
	 public List<CartItem> getAllItems(int userId);
	 public CartItem addToCart(CartItem cartItem);
	 public Boolean deleteCartItem(int cartId);
	
}
