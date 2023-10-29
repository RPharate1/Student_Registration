package com.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface StudentService {

	public List<Student> listAll();

	public void save(Student student);

	public Student getById(long id);

	public void delete(long id);
}
