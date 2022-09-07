package com.xpu.hrms.entity;

public class DbPosition {
	private String id;
	private String position;
	private String position_level;
	private double position_salary;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition_level() {
		return position_level;
	}
	public void setPosition_level(String position_level) {
		this.position_level = position_level;
	}
	public double getPosition_salary() {
		return position_salary;
	}
	public void setPosition_salary(double position_salary) {
		this.position_salary = position_salary;
	}
	@Override
	public String toString() {
		return "DbPosition [id=" + id + ", position=" + position + ", position_level=" + position_level
				+ ", position_salary=" + position_salary + "]";
	}
	
}
