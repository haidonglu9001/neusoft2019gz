package com.neusoft.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.security.model.UserModel;
@Mapper
public interface IUserMapper {

	public void create(UserModel um) throws Exception;
	
	public UserModel selectByUserName(String username) throws Exception;
}
