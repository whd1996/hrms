package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.entity.DbUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IDbUserMapper {
	List<HashMap<String, String>> listUser();
	List<DbUser> listUserByDepartment(String dep);
	DbUser getUserByID(String id);
	int addUser(DbUser user);
	int updateUser(DbUser user);
	int deleteUser(DbUser user);
	DbUser loginByUserNameAndPassword(DbUser user);
	//权限管理 职位部门和权限展示
	List<Map<String, String>> listUserRole();
	//修改员工权限
	int updateUserRoleById(String id, int role);
	List<DbUser> listUserByZhuGuan(DbStaff staff);
	//展示待面试员工
	List<DbUser> listUserForAddStaff();
	int selectUserByUserAccount(DbUser user);
	DbUser selectUserById(String id);
	
	DbUser selectUserByUserAccountInfo(DbUser user);
	//修改密码
	int updateUserPwd(DbUser user);
}
