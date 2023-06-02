package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao {
	
		
		HelperClass helperClass=new HelperClass();

		//To save a student
		  Connection connection=null;
		  
		  public boolean updatedStudentById (int id,String email) {
		  connection=helperClass.getConnection();
		  String sql="update student set email=? where id=?";
		  try {
			PreparedStatement pdst=connection.prepareStatement(sql);
			pdst.setString(1, email);
			pdst.setInt(2,id);
			//execute
			pdst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		  return true;
		  
		  
		  }
		  
		//get all
		  public List<Student> getAllStudents() {
			  connection=helperClass.getConnection();
			  String sql="SELECT * FROM student";
			  ArrayList<Student> al=null;
			  
			  try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				         //execute the query
				ResultSet resultSet=preparedStatement.executeQuery();
				al=new ArrayList<>();
				while(resultSet.next()) {
					int id =resultSet.getInt(1);
					String name=resultSet.getString(2);
					String email=resultSet.getString(3);
					Student s =new Student();
					s.setId(id);
					s.setName(name);
					s.setEmail(email);
					al.add(s);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return al;
			
		}
		
		  
		 
		  // delete the student
	    public boolean deleteStudentById(int id) {
				connection=  helperClass.getConnection();
				String sql="DELETE FROM student WHERE id=?"; 
				boolean  res=false;
				
				try {
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.setInt(1, id);
					
					//Execute 
					int res2=preparedStatement.executeUpdate();
					if(res2>0) {
						res=true;
					}
					else {
						res=false;
					}
					
				} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return res;
				
			  }
	    
	    
	    
	    
		public Student  saveStudent(Student student){
			Connection connection=helperClass.getConnection();
			
	  
			
			String sql="INSERT INTO student VALUES(?,?,?)";
			
			//Create statement
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
				preparedStatement.setInt(1,student.getId());
				preparedStatement.setString(2, student.getName());
				preparedStatement.setString(3, student.getEmail());
				
				
				// Execute the statement
				preparedStatement.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return student;
			
		}
		
		public Student getStudentById(int id){
			
			 connection=helperClass.getConnection();
			 String url="SELECT * FROM student where Id=?";
			 Student s=new  Student();
			try {
				PreparedStatement	prst = connection.prepareStatement(url);
				prst.setInt(1, id);
			    ResultSet rst=prst.executeQuery();
			     
			    while(rst.next())
			    {
			    	int id2=rst.getInt(id);
			    	String name=rst.getString(2);
			    	String email=rst.getString(3);
			    	
			    	s.setId(id2);
			    	s.setName(name);
			    	s.setEmail(email);
			    }
			     

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return s;
		}
			
			
			
			
			
			
			
			
			
			
			
			  
			 
	}
