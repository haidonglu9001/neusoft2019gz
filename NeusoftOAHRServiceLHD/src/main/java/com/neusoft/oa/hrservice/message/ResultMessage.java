package com.neusoft.oa.hrservice.message;

import java.util.List;



import lombok.Data;
@Data
public class ResultMessage<T> {

	private static final long serialVersionUID = 1L;
	private T model=null; //业务对象
	private List<T> list=null; //业务对象的列表
	private String status=null;
	private String message=null;
	private int rows=0; //每屏显示的行数
	private int page=0; //第几页
	private int count=0; //信息T的个数
	private int pageCount=0; //页数
	
	public ResultMessage() {
		
	}
	public ResultMessage(String status,String message) {
		this.status=status;
		this.message=message;
	}
	
}
