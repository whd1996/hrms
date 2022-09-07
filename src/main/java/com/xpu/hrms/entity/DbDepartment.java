package com.xpu.hrms.entity;

public class DbDepartment {
	// 部门id
	private String id;
	// 部门名称
	private String department_name;
	// 部门职位
	private String position;
	// 职责描述
	private String duty;

	// 新部门名
	private String newDepartment_name;

	public String getNewDepartment_name() {
		return newDepartment_name;
	}

	public void setNewDepartment_name(String newDepartment_name) {
		this.newDepartment_name = newDepartment_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	@Override
	public String toString() {
		return "DbDepartment [id=" + id + ", department_name=" + department_name + ", position=" + position + ", duty="
				+ duty + ", newDepartment_name=" + newDepartment_name + "]";
	}

}
