package com.neusoft.oa.message;

import java.io.Serializable;
/*
 * 模块：公共基础工具类，
 * 公共的控制层
 * @Author: 吕海东
 */
public class ResultMessage<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T model=null;
	private String statu=null;
	private String message=null;

}
