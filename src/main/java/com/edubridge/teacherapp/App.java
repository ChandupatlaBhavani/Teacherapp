package com.edubridge.teacherapp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.teacherapp.model.Teacher;
import com.edubridge.teacherapp.service.TeacherService;

public class App{
	public static void main(String[] args) {
		TeacherService service=new TeacherService();
		Scanner in= new Scanner(System.in);
		while(true) {
			System.out.println("my teacher application");
			System.out.println("++++++++++++++++++++++++++++");
			System.out.println("1.Add Teacher");
			System.out.println("2.View Teacher");
			System.out.println("3.Update Teacher");
			System.out.println("4.Delete All Teacher");
			System.out.println("5.Search Teacher");
			System.out.println("0.Exit");
			System.out.println("please choose option: ");
			int option= in.nextInt();
			
			switch(option) {
			case 1:
				//Add Teacher
				System.out.println("add teacher details");
				System.out.println("--------------");
				
				System.out.println("Enter Id: ");
				int id=in.nextInt();
				
				System.out.println("Enter Name: ");
				String name=in.next();
				
				System.out.println("Enter Mobile: ");
				Long mobile=in.nextLong();
				
				System.out.println("Enter Subjecttaught: ");
				String subjecttaught=in.next();
				
				Teacher newTeacher = new Teacher();
				newTeacher.setId(id);
				newTeacher.setName(name);
				newTeacher.setMobile(mobile);
				newTeacher.setSubjecttaught(subjecttaught);
				
				int status = service.addteacher(newTeacher);
				if(status >=1) {
					System.out.println("New teacher added successfully!");
				}else {
					System.out.println("Something is wrong");
				}
				break;
			case 2:
				//View Teacher
				System.out.println("display all teachers");
				System.out.println("---------------");
				List<Teacher> teachers= service.getAllTeachers();
				for(Teacher t: teachers) {
					System.out.println(t.getId()+"\t"+t.getName()+"\t"+t.getMobile()+"\t"+t.getSubjecttaught());
				}	
				break;
			case 3:
				// Update Teacher
                System.out.println("Update Teacher");
                System.out.print("Enter Teacher ID to Update: ");
                int updateId = in.nextInt();
                System.out.print("Enter New Name: ");
                String newName = in.next();
                System.out.print("Enter New Mobile: ");
                Long newMobile = in.nextLong();
                System.out.print("Enter New Subjecttaught: ");
                String newSubject = in.next();

                Teacher updatedTeacher = new Teacher();
                updatedTeacher.setId(updateId);
                updatedTeacher.setName(newName);
                updatedTeacher.setMobile(newMobile);
                updatedTeacher.setSubjecttaught(newSubject);
                
                int updateStatus = service.updateTeacher(updatedTeacher);
                System.out.println(updateStatus >= 1 ? "Teacher updated successfully!" : "Teacher not found.");
                break;
				
			case 4:
				// Delete All Teachers
                System.out.print("Are you sure you want to delete all teachers? (yes/no): ");
                String confirm = in.next();
                if (confirm.equalsIgnoreCase("yes")) {
                    service.getAllTeachers();
                    System.out.println("All teachers deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                break;
			case 5:
				//Search Teacher
                System.out.print("Enter Name of the Teacher to search: ");
                String searchName = in.nextLine();
                Teacher foundTeacher = service.getTeacherByName(searchName);
                if (foundTeacher >= 1) {
                    System.out.println("Teacher found: " + foundTeacher.getId() + "\t" + foundTeacher.getName() + "\t" + foundTeacher.getMobile() + "\t" + foundTeacher.getSubjecttaught() + "\t");
                } else {
                    System.out.println("Teacher not found.");
                }
                break;
			case 0:
				System.out.println("bye!!!");
				System.exit(0);
			default:
				System.out.println("invalid option selected!");
				break;
			}
		}
	}
}
