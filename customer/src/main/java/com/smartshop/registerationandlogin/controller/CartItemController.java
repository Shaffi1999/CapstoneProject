package com.smartshop.registerationandlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshop.registerationandlogin.entity.CartItem;
import com.smartshop.registerationandlogin.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartItemController {
	@Autowired
	private CartServiceImpl cartService;

	@PostMapping("/addToCart")

	public CartItem addToCartItem(@RequestBody CartItem cartItem) {
		return cartService.addToCart(cartItem);
	}

	@GetMapping("/totalprice/{id}")
	public long getTotalPrice(@PathVariable("id") int id) {
		return cartService.calculatePrice(id);
	}

	@GetMapping("/allitemsbyid/{id}")
	public List<CartItem> getAll(@PathVariable("id") int id) {
		return cartService.getAllItems(id);
	}

	@DeleteMapping("/deleteitem/{id}")
	public Boolean deleteItem(@PathVariable("id") int id) {
		return cartService.deleteCartItem(id);
	}

}
