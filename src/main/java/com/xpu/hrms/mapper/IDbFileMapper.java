package com.xpu.hrms.mapper;

import com.xpu.hrms.entity.DbFile;

import java.util.List;



public interface IDbFileMapper {
	//查询
	List<DbFile> listFile();
	//插入
	int addFile(DbFile file);
	//删除
	int deleteFile(DbFile file);
	//修改
	int updateFile(DbFile file);
	//分页
	int getFileCount();
	//根据ID查所有信息
	DbFile getFileByID(String id);
}
