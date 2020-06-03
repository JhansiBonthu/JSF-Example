package com.song.jsf.example;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String educationLevel;

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Student() {
	}

	public Student(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Student clone() {
		return new Student(id, name, age);
	}

	public void restore(Student student) {
		this.id = student.getId();
		this.name = student.getName();
		this.age = student.getAge();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		if (age > 12 && age <= 16)
			setEducationLevel("Elementary");
		else if (age > 16 && age <= 22)
			setEducationLevel("Secondary");
		else
			setEducationLevel("Higher");
	}
}
