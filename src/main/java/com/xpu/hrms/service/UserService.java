package com.xpu.hrms.service;

import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.entity.DbUser;
import com.xpu.hrms.mapper.IDbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
	@Autowired
	private IDbUserMapper userMapper;

	public List<HashMap<String, String>> listUser() {
		return this.userMapper.listUser();
	}

	public int addUser(DbUser user) {
		Date date = new Date();
		String creat_time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date).toString();
		user.setCreat_time(creat_time);
		return this.userMapper.addUser(user);
	}

	public boolean updateUser(DbUser user) {
		return this.userMapper.updateUser(user) > 0;
	}

	public DbUser loginByUserNameAndPassword(DbUser user) {
		return this.userMapper.loginByUserNameAndPassword(user);
	}

	public List<Map<String, String>> listUserRole() {

		return this.userMapper.listUserRole();
	}

	public List<DbUser> listUserByDepartment(String dep) {

		return userMapper.listUserByDepartment(dep);
	}

	public int updateUserRoleById(String id, int role) {
		// TODO Auto-generated method stub
		return userMapper.updateUserRoleById(id, role);
	}

	// 修改密码
	public boolean updateUserPwd(DbUser user) {

		return this.userMapper.updateUserPwd(user) > 0;
	}

	public List<DbUser> listUserByZhuGuan(DbStaff staff) {

		return userMapper.listUserByZhuGuan(staff);
	}

	public List<DbUser> listUserForAddStaff() {

		return userMapper.listUserForAddStaff();
	}

	public int selectUserByUserAccount(DbUser user) {

		return userMapper.selectUserByUserAccount(user);
	}

	public DbUser selectUserById(String id) {

		return userMapper.selectUserById(id);
	}

	public int deleteUser(DbUser user) {
		return this.userMapper.deleteUser(user);
	}

	public DbUser selectUserByUserAccountInfo(DbUser user) {

		return userMapper.selectUserByUserAccountInfo(user);
	}

}
