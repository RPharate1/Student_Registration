package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Student;
import com.app.repository.studentRepository;
import com.app.service.StudentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentDaoImple implements StudentService{

	@Autowired
	studentRepository studentRepo;

	public List<Student> listAll() {
		return studentRepo.findAll();
	}

	public void save(Student student) {
		studentRepo.save(student);
	}

	public Student getById(long id) {
		return studentRepo.findById(id).get();
	}

	public void delete(long id) {
		studentRepo.deleteById(id);

	}

}
