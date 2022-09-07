package com.xpu.hrms.entity;

public class DbFile {
	 //制度文件管理id
		private String id;
		//制度文件管理file_name
		private String file_name;
		//制度文件管理fil_content
		private String file_content;
		//制度文件管理post_time
		private String post_time;
		//制度文件管理post_staff
		private String post_staff;
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFile_name() {
			return file_name;
		}
		public void setFile_name(String file_name) {
			this.file_name = file_name;
		}
		public String getFile_content() {
			return file_content;
		}
		public void setFile_content(String fil_content) {
			this.file_content = fil_content;
		}
		public String getPost_time() {
			return post_time;
		}
		public void setPost_time(String post_time) {
			this.post_time = post_time;
		}
		public String getPost_staff() {
			return post_staff;
		}
		public void setPost_staff(String post_staff) {
			this.post_staff = post_staff;
		}
}
