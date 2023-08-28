package com.recell.service;

import com.recell.exception.UserException;
import com.recell.model.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;

	public User findUserProfileByJwt(String jwt) throws UserException;

}
