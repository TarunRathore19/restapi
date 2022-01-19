package com.example.myapi.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.myapi.entities.Student;
import java.sql.*;

public class StudentDao {
 
   //make method here to access database - select, update,delete, insert
     String jdbcdriver = "com.mysql.cj.jdbc.Driver";
     String dburl = "jdbc:mysql://localhost:3306/mydb";
     String dbuser = "root";
     String dbpass = "Tarun12345";
     
     Connection conn;
     Statement st;
     {
     try {
    	 Class.forName(jdbcdriver);
    	 conn = DriverManager.getConnection(dburl, dbuser, dbpass);
    	 st = conn.createStatement();
     }catch(Exception e) {}
     }
     
     public void insertStudent(Student student) {
		 String input = "INSERT INTO student(id,firstname,lastname,email) values ('"+
	                student.getId()+"', '"+
	                student.getFirstname()+"','"+
	                student.getLastname()+"', '"+
	                student.getEmail()+"')";
		 try {
			 st.execute(input);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> selectStudent() {
		List<Student> list = new ArrayList<>();
		String surl = "select * from student";
		try {
			ResultSet rs = st.executeQuery(surl);
			while(rs.next()){  
				list.add(new Student(rs.getString("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email")));  
				}  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void upStudent(Student student) {
		String upurl = "update student set firstname = "+"'"+student.getFirstname()+"',"+
				" lastname = "+"'"+student.getLastname()+"',"+
			    " email = "+"'"+student.getEmail()+"'"+
			    " where id = "+"'"+student.getId()+"';";
		try {
			st.executeUpdate(upurl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeStudent(String id) {
		String removeurl = "delete from student where id = "+"'"+id+"';";
		try {
			st.executeUpdate(removeurl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
     
     
}
