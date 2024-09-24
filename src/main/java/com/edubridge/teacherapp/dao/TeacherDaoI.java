package com.edubridge.teacherapp.dao;

import java.util.List;

import com.edubridge.teacherapp.model.Teacher;

public interface TeacherDaoI {
	int addteacher(Teacher t);
	List<Teacher> getAllTeachers();
	Teacher getTeacherByName(String name);
	int updateTeacher(Teacher t);
	void deleteTeacher(String name);
	int deleteTeacher(int deleteId);
	int searchTeacher(int id);
}



