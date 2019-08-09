package com.neusoft.oa.message;

import java.io.Serializable;

import lombok.Data;
/*
 * 模块：公共基础工具类，
 * 公共的控制层
 * @Author: 吕海东
 */
@Data
public class ResultMessage<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T model=null;
	private String status=null;
	private String message=null;
	
	public ResultMessage() {
		
	}
	public ResultMessage(String status,String message) {
		this.status=status;
		this.message=message;
	}
	

}
