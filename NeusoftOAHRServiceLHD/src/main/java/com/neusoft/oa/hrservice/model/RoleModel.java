package com.neusoft.oa.hrservice.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;



import lombok.Data;

@Alias("Role")
@Data
public class RoleModel implements Serializable{
	private int no=0;
	private String name=null;
	

}
