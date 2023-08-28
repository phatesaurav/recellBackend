package com.recell.service;

import com.recell.exception.ProductException;
import com.recell.model.Cart;
import com.recell.model.User;
import com.recell.request.AddItemRequest;

public interface CartService {

	public Cart createCart(User user);

	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

	public Cart findUserCart(Long userId);
	

}
