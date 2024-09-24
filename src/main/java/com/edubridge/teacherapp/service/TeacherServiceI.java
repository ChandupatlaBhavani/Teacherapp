package com.edubridge.teacherapp.service;

import java.util.List;
import com.edubridge.teacherapp.model.Teacher;

public interface TeacherServiceI{
	int addteacher(Teacher t);
	List<Teacher> getAllTeachers();
	Teacher getTeacherByName(String name);
	int updateTeacher(Teacher t);
	void deleteTeacher(String name);
	int deleteTeacher(int deleteId);
	void deleteAllTeacher(String name);
	int searchTeacher(int searchId);
}
