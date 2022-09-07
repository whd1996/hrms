package com.xpu.hrms.service;

import com.xpu.hrms.entity.DbFile;
import com.xpu.hrms.mapper.IDbFileMapper;
import com.xpu.hrms.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FileService {
	 @Autowired
	 private IDbFileMapper fileMapper;
	 /**
		 * 查询所有制度信息
		 * 
		 * @return
		 */
	 @Transactional
	 public List<DbFile> listFile(){
		 return this.fileMapper.listFile();
	 }
	 /**
		 * 添加制度信息
		 * 
		 * @return
		 */
	 @Transactional
	 public int addFile(DbFile file) {
		 //新增记录
		 file.setId(UUIDUtil.createUUID());
		 file.setFile_name(file.getFile_name());
		 file.setFile_content(file.getFile_content());
		 file.setPost_time(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()).toString());
		 return this.fileMapper.addFile(file);
	 
	 }
	 /**
		 * 更新制度信息
		 * 
		 * @return
		 */
	 public boolean updateFile(DbFile file) {
		 return this.fileMapper.updateFile(file)>0;
	 }
	 
	 /**
		 * 删除制度信息
		 * 
		 * @return
		 */
	 public int deleteFile(DbFile file) {
		 if(file.getId()==null) {
			 return 0;
		 }
		 return this.fileMapper.deleteFile(file);
	 }
	 /**
		 * 分页制度信息
		 * 
		 * @return
		 */
	 public int getFileCount() {
		 return this.fileMapper.getFileCount();
	 }
	 /**
		 * 根据ID查制度信息
		 * 
		 * @return
		 */
	 
	 public DbFile getFileByID(String id) {
		 return this.fileMapper.getFileByID(id);
	 }
}
