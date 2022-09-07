package com.xpu.hrms.entity;

public class DbUser {
	private String id;
	private String staff_name;
	private String user_account;
	private String user_password;
	private String creat_time;
	private int role_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}
	@Override
	public String toString() {
		return "DbUser [id=" + id + ", staff_name=" + staff_name + ", user_account=" + user_account + ", user_password="
				+ user_password + ", creat_time=" + creat_time + ", role_id=" + role_id + "\n]";
	}
	
	

}
