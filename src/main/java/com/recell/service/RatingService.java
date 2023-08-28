package com.recell.service;

import java.util.List;

import com.recell.exception.ProductException;
import com.recell.model.Rating;
import com.recell.model.User;
import com.recell.request.RatingRequest;

public interface RatingService {

	public Rating createRating(RatingRequest req, User user) throws ProductException;

	public List<Rating> getProductsRating(Long productId);

}
