package com.neusoft.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.neusoft.security.model.UserModel;

public interface IUserService extends UserDetailsService {

	public void add(UserModel um) throws Exception;
	
	public UserModel getByUserName(String username) throws Exception;
}
