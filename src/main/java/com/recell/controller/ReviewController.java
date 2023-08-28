package com.recell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recell.exception.ProductException;
import com.recell.exception.UserException;
import com.recell.model.Review;
import com.recell.model.User;
import com.recell.request.ReviewRequest;
import com.recell.service.ReviewService;
import com.recell.service.UserService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<Review> createReviewHandler(@RequestBody ReviewRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException {
		
		User user = userService.findUserProfileByJwt(jwt);

		Review review = reviewService.createReview(req, user);

		return new ResponseEntity<Review>(review, HttpStatus.ACCEPTED);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<List<Review>> getProductsReviewHandler(@PathVariable Long productId) {
		List<Review> reviews = reviewService.getAllReview(productId);
		return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
	}

}

