package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbDepartment;

import java.util.List;

public interface IDbDepartmentMapper {
	List<DbDepartment> listDepartment();

	DbDepartment selectDepartmentById(String id);

	int addDepartment(DbDepartment dept);

	int updateDepartment(DbDepartment dept);

	int deleteDepartment(DbDepartment dept);

	int selectDpPositionByPositionName(String position);

	DbDepartment selectDpByPAndDP(String dp, String p);
}
