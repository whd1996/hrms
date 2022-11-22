package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDbDepartmentMapper {
	List<DbDepartment> listDepartment();

	DbDepartment selectDepartmentById(String id);

	int addDepartment(DbDepartment dept);

	int updateDepartment(DbDepartment dept);

	int deleteDepartment(DbDepartment dept);

	int selectDpPositionByPositionName(String position);

	DbDepartment selectDpByPAndDP(@Param("dp") String dp, @Param("p") String p);
}
