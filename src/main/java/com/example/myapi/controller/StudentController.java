package com.example.myapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapi.entities.Student;
import com.example.myapi.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return this.studentservice.getStudent();
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return this.studentservice.addStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentservice.updateStudent(student);
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId){
		try {
			this.studentservice.deleteStudent(studentId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
