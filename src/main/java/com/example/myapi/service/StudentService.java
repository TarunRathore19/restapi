package com.example.myapi.service;

import java.util.List;
import com.example.myapi.entities.Student;

public interface StudentService {
	
	public List<Student> getStudent();
    
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public Student deleteStudent(String id);
}
