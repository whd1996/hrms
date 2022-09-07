package com.xpu.hrms.service;

import com.xpu.hrms.entity.DbDepartment;
import com.xpu.hrms.mapper.IDbDepartmentMapper;
import com.xpu.hrms.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
	@Autowired
	private IDbDepartmentMapper deptMapper;

	public List<DbDepartment> listDepartment() {
		return this.deptMapper.listDepartment();
	}

	public int addDepartment(DbDepartment dept) {
		dept.setId(UUIDUtil.createUUID());
		return this.deptMapper.addDepartment(dept);
	}

	public boolean updateDepartment(DbDepartment dept) {
		return this.deptMapper.updateDepartment(dept) > 0;
	}

	public int deleteDepartment(DbDepartment dept) {

		return this.deptMapper.deleteDepartment(dept);
	}

	public int selectDpPositionByPositionName(String position) {

		return deptMapper.selectDpPositionByPositionName(position);
	}

	public DbDepartment selectDpByPAndDP(String dp, String p) {
		
		return deptMapper.selectDpByPAndDP(dp,p);
	}

	public DbDepartment selectDepartmentById(String id) {
		
		return deptMapper.selectDepartmentById(id);
	}
}
