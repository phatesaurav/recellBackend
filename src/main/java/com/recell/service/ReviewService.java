package com.recell.service;


import java.util.List;

import com.recell.exception.ProductException;
import com.recell.model.Review;
import com.recell.model.User;
import com.recell.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req, User user) throws ProductException;

	public List<Review> getAllReview(Long productId);

}
