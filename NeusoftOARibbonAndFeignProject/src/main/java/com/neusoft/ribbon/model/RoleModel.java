package com.neusoft.ribbon.model;

import java.io.Serializable;

public class RoleModel implements Serializable{
	private int no=0;
	private String name=null;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
