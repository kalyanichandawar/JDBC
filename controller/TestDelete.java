package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.mysql.cj.protocol.SocksProxySocketFactory;

public class TestDelete {
	
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		System.out.println(studentDao.deleteStudentById(2));
	}
	

}