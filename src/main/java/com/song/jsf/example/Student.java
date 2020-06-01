package com.song.jsf.example;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Student.class.getName());
	private Long id;
	private String name;
	private int age;

	public Student() {}
	
	public Student(Long id, String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Override
	public Student clone() {
		return new Student(id, name,age);
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
	}
}
