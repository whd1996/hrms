package com.xpu.hrms.entity;

public class DbStaff {

	// 员工id
	private String id;
	// 员工名字
	private String name;
	// 员工性别
	private String sex;
	// 员工年龄
	private int age;
	// 员工籍贯
	private String place;
	// 员工生日
	private String birth;

	// 员工联系电话
	private String tel;
	// 员工部门
	private String staff_department;
	// 员工职位
	private String staff_position;
	//员工职位等级
	//private String staff_position_level;
	// 员工入职时间
	private String entry_time;
	// 员工离职时间
	private String leave_time;
	private String isdelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStaff_department() {
		return staff_department;
	}

	public void setStaff_department(String staff_department) {
		this.staff_department = staff_department;
	}

	public String getStaff_position() {
		return staff_position;
	}

	public void setStaff_position(String staff_position) {
		this.staff_position = staff_position;
	}

	public String getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}

	public String getLeave_time() {
		return leave_time;
	}

	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}


	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "DbStaff [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", place=" + place
				+ ", birth=" + birth + ", tel=" + tel + ", staff_department=" + staff_department + ", staff_position="
				+ staff_position + ", entry_time=" + entry_time + ", leave_time=" + leave_time + ", isdelete="
				+ isdelete + "\n]";
	}
	
}
