package com.neusoft.oa.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.BehaveModel;

/*
 * 爱好业务层接口
 * @Author: 吕海东
 */
public interface IBehaveService {

	//增加
	public void add(BehaveModel behave) throws Exception;
	//修改
	public void modify(BehaveModel behave) throws Exception;
	//删除
	public void delete(BehaveModel behave) throws Exception;
	//取得爱好单个对象
	public BehaveModel getByNo(int no) throws Exception;
	//取得所有爱好列表
	public List<BehaveModel> getListByAll() throws Exception;
	//取得所有爱好列表,分页模式
	public List<BehaveModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得爱好的个数
	public int getCountByAll() throws Exception;
}
