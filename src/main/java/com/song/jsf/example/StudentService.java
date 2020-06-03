package com.song.jsf.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	// getting all Student record by using the method findaAll() of CrudRepository
	public List<Student> getAllStudents() {
		List<Student> student = new ArrayList<Student>();
		studentRepository.findAll().forEach(student1 -> student.add(student1));
		return student;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(long id) {
		studentRepository.deleteById(id);
	}

	// updating a record
	public void update(Student student, long studentid) {
		studentRepository.save(student);
	}

}
