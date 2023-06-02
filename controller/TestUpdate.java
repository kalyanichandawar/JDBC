package com.jsp.controller;

import com.jsp.dao.StudentDao;

public class TestUpdate {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		String email="abc@gmail.com";
		boolean b =studentDao.updatedStudentById(1, email);
		System.out.println(b);
	}

}
