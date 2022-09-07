package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbStaff;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface IDbStaffMapper {

	//分页查询所有员工
	List<HashMap<String, String>> listStaff();
	
	LinkedList<DbStaff> selectStaffByDeptInfo(String dpname, String pname);
	
	ArrayList<DbStaff> selectStaffByPositionInfo(String position, String position_level);
	//统计员工数量
	int getStaffCount();
	
	//添加员工信息（员工入职）
	int addStaff(@Param("st")DbStaff staff);
	
	//修改员工信息（通过ID）
	int updateStaff(DbStaff staff);
	
	//删除员工信息（通过ID）
	int deleteStaff(DbStaff staff);

	DbStaff selectStaffById(String id);

	List<DbStaff> listUserByZhuGuan(DbStaff staff);

	List<DbStaff> listStaffByZhuGuan(DbStaff staff);

	List<DbStaff> listStaffByDepartment(DbStaff staff);

	List<DbStaff> listLeaveStaff(String name);

	List<HashMap<String, String>> listStaffData();

	int deleteStaffData(String id);


}
