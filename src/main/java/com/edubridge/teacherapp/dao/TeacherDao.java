package com.edubridge.teacherapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.teacherapp.model.Teacher;
import com.edubridge.teacherapp.utils.DBUtils;

/*
DAO-Data Access Object
To maintain only data persistence logic (JDBC Code)
*/
public class TeacherDao implements TeacherDaoI {
    private static Connection con = null;
    
    static{
        con=DBUtils.getConnection();    
    }

	@Override
	public int addteacher(Teacher t) {
		String insert="insert into teacher_details(id,name,mobile,subjecttaught) values(?,?,?,?)";
        int status=0;
        
        try {
            PreparedStatement ps=con.prepareStatement(insert);
            ps.setInt(1,t.getId());
            ps.setString(2, t.getName());
            ps.setLong(3, t.getMobile());
            ps.setString(4, t.getSubjecttaught());
            status=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers=new ArrayList<Teacher>();
        String select="select * from teacher_details";
        try {
            PreparedStatement ps=con.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Teacher teacher=new Teacher();
            	teacher.setId(rs.getInt("id"));
            	teacher.setName(rs.getString("name"));
            	teacher.setMobile(rs.getLong("mobile"));
            	teacher.setSubjecttaught(rs.getString("subjecttaught"));
            	teachers.add(teacher);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return teachers;
    }

	@Override
	public Teacher getTeacherByName(String name) {
	        Teacher teacher = null;
	        String select = "SELECT * FROM teacher_details WHERE name = ?";
	        try {
	            PreparedStatement ps = con.prepareStatement(select);
	            ps.setString(1, name);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                teacher = new Teacher();
	                teacher.setId(rs.getInt("id"));
	                teacher.setName(rs.getString("name"));
	                teacher.setMobile(rs.getLong("mobile"));
	                teacher.setSubjecttaught(rs.getString("subjecttaught"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return teacher;
	    }
	@Override
	public int updateTeacher(Teacher t) {
		String update = "UPDATE teacher_details SET name = ?, mobile = ?, subjecttaught = ? WHERE id = ?";
        int status = 0;

        try {
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, t.getName());
            ps.setLong(2, t.getMobile());
            ps.setString(3, t.getSubjecttaught());
            ps.setInt(4, t.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

	@Override
	public int deleteTeacher(int deleteId) {
		String deleteAll = "DELETE FROM teacher_details";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteAll);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return deleteId;
	}

	@Override
    public int searchTeacher(int id) {
        Teacher teacher = null;
        String select = "SELECT * FROM teacher_details WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setMobile(rs.getLong("mobile"));
                teacher.setSubjecttaught(rs.getString("subjecttaught"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return id; 
    }

	@Override
	public void deleteTeacher(String name) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public int addTeacher(Teacher t) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}

	
	