package com.neusoft.oa.hr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.oa.hr.mapper.IEmployeeMapper;
import com.neusoft.oa.hr.model.EmployeeModel;
import com.neusoft.oa.hr.service.IEmployeeService;
/*
 * 模块：人力资源HR
 * 员工部门业务实现类
 * @Author: 吕海东
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeMapper employeeMapper=null;
	@Override
	public void add(EmployeeModel employee) throws Exception {
		employeeMapper.insert(employee);

	}

	@Override
	public void addWithPhoto(EmployeeModel employee) throws Exception {
		employeeMapper.insertWithPhoto(employee);

	}

	@Override
	public void modify(EmployeeModel employee) throws Exception {
		employeeMapper.update(employee);

	}

	@Override
	public void modifyWithPhoto(EmployeeModel employee) throws Exception {
		employeeMapper.updateWithPhoto(employee);

	}

	@Override
	public void modifyForDeletePhoto(EmployeeModel employee) throws Exception {
		employeeMapper.updateForDeletePhoto(employee);

	}

	@Override
	public void delete(EmployeeModel employee) throws Exception {
		employeeMapper.delete(employee);

	}

	@Override
	public EmployeeModel getByIdWithDepartmentAndRoles(String id) throws Exception {
		
		return employeeMapper.selectByIdWithDepartmentAndRoles(id);
	}

	@Override
	public List<EmployeeModel> getListByAllWithoutDepartmentAndRoles() throws Exception {
		return employeeMapper.selectListByAllWithoutDepartmentAndRoles();
	}

	@Override
	public List<EmployeeModel> getListByAllWithoutDepartmentAndRolesWithPage(int rows, int page) throws Exception {
		
		return employeeMapper.selectListByAllWithoutDepartmentAndRolesWithPage(rows*(page-1), rows);
	}
	//取得员工列表，取关联的部门，不取关联的爱好
	@Override
	public List<EmployeeModel> getListByAllWithDepartmentWithoutRoles() throws Exception {
		
		return employeeMapper.selectListByAllWithDepartmentWithoutRoles();
	}

	@Override
	public List<EmployeeModel> getListByConditionWithDepartmentWithoutRolesWithPage(int departmentNo, int roleNo,
			String sex, Date startJoinDate, Date endJoinDate, int rows, int page) throws Exception {
		
		return employeeMapper.selectListByConditionWithDepartmentNoAndRolesWithPage(departmentNo, roleNo, sex, startJoinDate, endJoinDate, rows*(page-1), rows);
	}

	@Override
	public int getCountByConditionWithDepartmentNoAndRolesWithPage(int departmentNo, int roleNo,
			String sex, Date startJoinDate, Date endJoinDate) throws Exception {
		
		return employeeMapper.selectCountByCondition(departmentNo, roleNo, sex, startJoinDate, endJoinDate);
	}

	@Override
	public void addRoles(String id, int[] Roles) throws Exception {
		employeeMapper.addRoles(id, Roles);

	}

	@Override
	public void deleteRoles(String id) throws Exception {
		employeeMapper.deleteRoles(id);

	}

}
