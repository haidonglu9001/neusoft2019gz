package com.neusoft.busmis.security.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//系统功能Model类
@Alias("Function")
@Data
public class FunctionModel implements Serializable{
	private int no=0;
	private String name=null;
	private String url=null;
	private ModuleModel module=null; //外键字段对应的类型
	
	
}
