package com.neusoft.busmis.security.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
//用户的Model类
@Alias("User")
@Data
public class UserModel implements Serializable {
	private String id=null;
	private String password=null;
	private String name=null;
	private int age=0;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joinDate=null;
	private String status=null; //用户的状态， Y:激活， N:不激活的
	private String statusName=null; //状态的名称，不从数据库中取得。
	private byte[] photo=null; //保存图片
	private String photoFileName=null;
	private String photoContentType=null; //图片的MIME类型
	//关联的角色列表
	private List<RoleModel> roles=null; 
	
	
}
