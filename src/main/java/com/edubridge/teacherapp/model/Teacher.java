package com.edubridge.teacherapp.model;
/*
Model
Entity
DTO-Data Transfer Object
POJO-Plain Old Java Object 
 */
public class Teacher {
	private int id;
	private String name;
	private Long mobile;
	private String subjecttaught;
	//private int salary;
	
	//generate getter and setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getSubjecttaught() {
		return subjecttaught;
	}
	public void setSubjecttaught(String subjecttaught) {
		this.subjecttaught = subjecttaught;
	}	
}