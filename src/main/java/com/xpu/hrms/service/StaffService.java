package com.xpu.hrms.service;

import com.xpu.hrms.entity.DbStaff;
import com.xpu.hrms.mapper.IDbStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class StaffService {
	@Autowired
	private IDbStaffMapper staffMapper;
	/**
	 * 查询所有员工
	 * 
	 * @return
	 */
	public List<HashMap<String, String>> listStaff() {
		
		return this.staffMapper.listStaff();
	}

	/**
	 * 统计员工数量
	 * 
	 * @return
	 */
	public int getStaffCount() {
		// TODO
		return this.staffMapper.getStaffCount();
	}

	/**
	 * 添加员工（员工入职）
	 * 
	 * @param staff
	 * @return
	 */
	@Transactional
	public int addStaff(DbStaff staff) {
		// TODO
		// 新增记录
		//staff.setId(UUIDUtil.createUUID());
		staff.setIsdelete("0");
		return this.staffMapper.addStaff(staff);
	}

	/**
	 * 修改员工 
	 * 
	 * @param staff
	 * @return
	 */
	@Transactional
	public int updateStaff(DbStaff staff) {
		// TODO
		// 修改记录
		// TODO
		if (staff.getId() == null) {
			return 0;
		}
		return this.staffMapper.updateStaff(staff);
	}

	/**
	 * 删除员工
	 * 
	 * @param staff
	 * @return
	 */
	@Transactional
	public int deleteStaff(DbStaff staff) {
		// TODO
		if (staff.getId() == null) {
			return 0;
		}
		return this.staffMapper.deleteStaff(staff);
	}

	public DbStaff selectStaffById(String id) {
		
		return staffMapper.selectStaffById(id);
	}

	public List<DbStaff> listStaffByZhuGuan(DbStaff staff) {
		
		return staffMapper.listStaffByZhuGuan(staff);
	}

	public List<DbStaff> listStaffByDepartment(DbStaff staff) {
		
		return staffMapper.listStaffByDepartment(staff);
	}

	public List<DbStaff> listLeaveStaff(String name) {
		// TODO Auto-generated method stub
		return staffMapper.listLeaveStaff(name);
	}

	public List<HashMap<String, String>> listStaffData() {
	
		return staffMapper.listStaffData();
	}

	public int deleteStaffData(String id) {
		
		return staffMapper.deleteStaffData(id);
	}

	public LinkedList<DbStaff> selectStaffByDeptInfo(String dpname, String pname) {
		
		return staffMapper.selectStaffByDeptInfo(dpname,pname);
	}

	public ArrayList<DbStaff> selectStaffByPositionInfo(String position, String position_level) {
	
		return staffMapper.selectStaffByPositionInfo(position,position_level);
	}


	

}
