package com.edubridge.teacherapp.service;

import java.util.List;

import com.edubridge.teacherapp.dao.TeacherDao;
import com.edubridge.teacherapp.model.Teacher;

public class TeacherService implements TeacherServiceI{
private TeacherDao dao;
	 public TeacherService() {
	     dao = new TeacherDao();
	 }
	@Override
	public int addteacher(Teacher t) {
		return dao.addteacher(t);
	}
	@Override
	public List<Teacher> getAllTeachers() {
		return dao.getAllTeachers();
	}
	@Override
	public Teacher getTeacherByName(String name) {
		return dao.getTeacherByName(name);
	}
	@Override
	public int updateTeacher(Teacher t) {
		return dao.updateTeacher(t);
	}
	
	@Override
	public int deleteTeacher(int deleteId) {
		return dao.deleteTeacher(deleteId);
	}
	
	@Override
	public int searchTeacher(int searchId) {
		return dao.searchTeacher(searchId);
	}
	
	@Override
	public void deleteAllTeacher(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteTeacher(String name) {
		// TODO Auto-generated method stub
		
	}
}
