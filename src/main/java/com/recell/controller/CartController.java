package com.recell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recell.exception.ProductException;
import com.recell.exception.UserException;
import com.recell.model.Cart;
import com.recell.model.User;
import com.recell.request.AddItemRequest;
import com.recell.response.ApiResponse;
import com.recell.service.CartService;
import com.recell.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException {

		User user = userService.findUserProfileByJwt(jwt);

		Cart cart = cartService.findUserCart(user.getId());

		System.out.println("cart - " + cart.getUser().getEmail());

		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException {
		
		System.out.println(req +"  user");

		User user = userService.findUserProfileByJwt(jwt);

		cartService.addCartItem(user.getId(), req);

		ApiResponse res = new ApiResponse("Item Added To Cart Successfully", true);

		return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);

	}
	

}