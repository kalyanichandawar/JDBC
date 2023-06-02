package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestSave {
	public static void main(String[] args) {
		Student student= new Student();
		student.setId(2);
		student.setName("xyz");
		student.setEmail("xyz@mail.com");
		
		StudentDao studentdao =new StudentDao();
		Student s=studentdao.saveStudent(student);
		
		System.out.println(s.getName()+" saved successfully");
				
	}

}
