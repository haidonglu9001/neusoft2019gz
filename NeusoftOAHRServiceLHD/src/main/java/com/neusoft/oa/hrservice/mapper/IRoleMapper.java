package com.neusoft.oa.hrservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import com.neusoft.oa.hrservice.model.RoleModel;
@Mapper
public interface IRoleMapper {
	
	public List<RoleModel> selectListByAll() throws Exception;

}
