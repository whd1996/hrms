package com.xpu.hrms.entity;

public class DbInterviewee {
	private String id;
	private String name;
	private int age;
	private String sex;
	private String desired_position;
	private String desired_department;
	private String work_experience;
	private String work_grade;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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

	public String getDesired_position() {
		return desired_position;
	}

	public void setDesired_position(String desired_position) {
		this.desired_position = desired_position;
	}

	public String getDesired_department() {
		return desired_department;
	}

	public void setDesired_department(String desired_department) {
		this.desired_department = desired_department;
	}

	public String getWork_experience() {
		return work_experience;
	}

	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
	}

	public String getWork_grade() {
		return work_grade;
	}

	public void setWork_grade(String work_grade) {
		this.work_grade = work_grade;
	}

	@Override
	public String toString() {
		return "DbInterviewee [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", desired_position="
				+ desired_position + ", desired_department=" + desired_department + ", work_experience="
				+ work_experience + ", work_grade=" + work_grade + "]";
	}

	
}
