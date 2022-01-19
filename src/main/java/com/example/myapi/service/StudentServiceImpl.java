package com.example.myapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.myapi.dao.StudentDao;
import com.example.myapi.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	StudentDao studentdao = new StudentDao();
	
	public StudentServiceImpl() {
		
	}
	
	@Override
	public List<Student> getStudent() {
		return studentdao.selectStudent();
	}

	@Override
	public Student addStudent(Student student) {
		studentdao.insertStudent(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		studentdao.upStudent(student);
		return student;
	}

	@Override
	public Student deleteStudent(String id) {
		studentdao.removeStudent(id);
		return null;
	}

}
