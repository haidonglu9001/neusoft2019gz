package com.neusoft.oa.hr.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/*
 * 员工角色的Model类
 * @Author: 吕海东
 */
@Alias("Role")
@Data
public class RoleModel implements Serializable{
	private int no=0;
	private String name=null;
	//爱好关联的员工列表
	private List<EmployeeModel> employees=null;
	
	
}
