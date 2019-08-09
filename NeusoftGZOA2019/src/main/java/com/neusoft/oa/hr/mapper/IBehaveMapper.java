package com.neusoft.oa.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.BehaveModel;
/*
 * 爱好的DAO层Mapper接口
 * @Author: 吕海东
 */
@Mapper
public interface IBehaveMapper {
	//增加
	public void insert(BehaveModel behave) throws Exception;
	//修改
	public void update(BehaveModel behave) throws Exception;
	//删除
	public void delete(BehaveModel behave) throws Exception;
	//取得爱好单个对象
	public BehaveModel selectByNo(int no) throws Exception;
	//取得所有爱好列表
	public List<BehaveModel> selectListByAll() throws Exception;
	//取得所有爱好列表,分页模式
	public List<BehaveModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得爱好的个数
	public int selectCountByAll() throws Exception;
	
}
