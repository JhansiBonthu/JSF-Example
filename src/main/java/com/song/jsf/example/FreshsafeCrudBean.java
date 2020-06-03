package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.song.jsf.example.util.CommonUtils;

@ManagedBean
@ViewScoped
@Named
public class FreshsafeCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentService studentService;
	private List<Student> students;
	private Student student = new Student();
	private Student beforeEditStudent = null;
	private boolean edit;

	private CommonUtils util = new CommonUtils();

	@PostConstruct
	public void init() {
		students = studentService.getAllStudents();
	}

	public void add() {
		studentService.saveOrUpdate(student);
		student = new Student();
		students = studentService.getAllStudents();
		if (util != null)
			util.redirectWithGet();
	}

	public void resetAdd() {
		student = new Student();
		students = studentService.getAllStudents();

		util.redirectWithGet();
	}

	public void edit(Student student) {
		beforeEditStudent = student.clone();
		this.student = student;
		edit = true;

		util.redirectWithGet();
	}

	public void cancelEdit() {
		this.student.restore(beforeEditStudent);
		this.student = new Student();
		edit = false;
		students = studentService.getAllStudents();

		util.redirectWithGet();
	}

	public void saveEdit() {
		if (this.student.getName().isEmpty())
			this.student.setName(beforeEditStudent.getName());
		if (this.student.getAge() == 0)
			this.student.setAge(beforeEditStudent.getAge());
		studentService.update(this.student, this.student.getId());
		this.student = new Student();
		students = studentService.getAllStudents();
		edit = false;

		util.redirectWithGet();
	}

	public void delete(Student student) throws IOException {
		studentService.delete(student.getId());
		students = studentService.getAllStudents();
		util.redirectWithGet();
	}

	public List<Student> getStudents() {
		return students;
	}

	public Student getStudent() {
		return this.student;
	}

	public boolean isEdit() {
		return this.edit;
	}

}
