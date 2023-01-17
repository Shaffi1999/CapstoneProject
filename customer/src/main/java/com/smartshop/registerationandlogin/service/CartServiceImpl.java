package com.smartshop.registerationandlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smartshop.registerationandlogin.entity.CartItem;
import com.smartshop.registerationandlogin.exception.CartItemNotAvailableException;
import com.smartshop.registerationandlogin.model.Product;
import com.smartshop.registerationandlogin.repository.CartItemRepository;
import com.smartshop.registerationandlogin.repository.UserRepository;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartItemRepository cartItemRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public long calculatePrice(Integer userId) {
		long totalPrice = 0l;
		List<CartItem> items = cartItemRepo.findCartItemByUserId(userId);
		for (CartItem item : items) {
			Product product = restTemplate.getForObject("http://localhost:8083/product/get/" + item.getProductId(),
					Product.class);
			totalPrice = totalPrice + (item.getQuantity() * product.getPrice());
		}

		return totalPrice;

	}

	@Override
	public List<CartItem> getAllItems(int userId) {
		return cartItemRepo.findCartItemByUserId(userId);
	}

	@Override
	public CartItem addToCart(CartItem cartItem) {
		Product product = restTemplate.getForObject("http://localhost:8083/product/get/" + cartItem.getProductId(),
				Product.class);
		System.out.println("Stock Count Is:" + product.getStockCount());
		if (product.getStockCount() == 0) {
			throw new CartItemNotAvailableException("Item Not Available Right Now");
		}
		if (!(product.getStockCount() >= cartItem.getQuantity())) {
			throw new CartItemNotAvailableException("Sorry you have choosen high quantity");
		}
		return cartItemRepo.save(cartItem);
	}

	@Override
	public Boolean deleteCartItem(int cartId) {
		CartItem cartItem = cartItemRepo.findById(cartId)
				.orElseThrow(() -> new CartItemNotAvailableException("No Cart Item Available with id:" + cartId));
		if (cartItem != null) {
			cartItemRepo.deleteById(cartId);
			return true;
		}
		return false;
	}

}
