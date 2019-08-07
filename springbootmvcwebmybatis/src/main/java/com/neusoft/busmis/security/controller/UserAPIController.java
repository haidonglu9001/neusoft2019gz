package com.neusoft.busmis.security.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

@RestController
//@ResponseBody
@RequestMapping("/api/user")
//@CrossOrigin
public class UserAPIController {
	
	@Autowired
	private IUserService us=null;
	
	//异常处理方法
	/*
	@ExceptionHandler
	public ResponseEntity<String> handle(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(),null,HttpStatus.EXPECTATION_FAILED);
	}
	*/
	@PostMapping(value="add01")
	public String add(String userid,String password, String name,int age, Date joinDate) throws Exception{
		
		
		return "OK";
		
	}
	@PostMapping(value="add02")
	public String add(@RequestBody UserModel um) throws Exception{
		
		System.out.println(um.getName());
		System.out.println(um.getJoinDate());
		return "OK";
		
	}
	
	@RequestMapping(path="/get/{userid}",method = {RequestMethod.POST,RequestMethod.GET})
	public UserModel getUser(@PathVariable String userid,@RequestHeader("token") String token,@CookieValue("JSESSIONID") String ssid, @SessionAttribute("userid") String uid)  throws Exception{
		System.out.println(token);
		System.out.println(ssid);
		return us.getById(userid);
	}
	@RequestMapping(path="/get01/{userid}",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<UserModel> getUser01(@PathVariable String userid)  throws Exception{
		
		UserModel um=us.getById(userid);
		//设定响应头
		MultiValueMap<String, String> headersMap=new LinkedMultiValueMap<String,String>();
		headersMap.add("token", "9999");
		headersMap.add("username", "LHD");
		headersMap.add("Content-Type", "image/jpeg");
		
		
		
		
		ResponseEntity<UserModel> resultEntity=new ResponseEntity<UserModel>(um,headersMap,HttpStatus.OK);
		
		
		return resultEntity;
		
	}
	
	@RequestMapping(value="/list")	
	public List<UserModel> getUserList() throws Exception{
		return us.getListByAll();
	}
	
	public void sendInfo(HttpServletResponse response,HttpSession session) throws Exception{
		
		
		
	}
	
	//编程练习: 参数：用户的ID， 功能：下载用的图像。
	public ResponseEntity<Byte[]> downPhoto(String id) throws Exception{
		
		return null;
	}

}
