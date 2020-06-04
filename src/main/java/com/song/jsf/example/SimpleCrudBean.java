package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.richfaces.component.SortOrder;
//import org.richfaces.component.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.jsf.example.util.CommonUtils;

@Named
public class SimpleCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SimpleCrudBean.class.getName());
    
	@Autowired
    private StudentService studentService;
	private List<Student> students;
    private Student student = new Student();
    private Student beforeEditStudent = null;
    private boolean edit;
    private SortOrder namesOrder = SortOrder.unsorted;
    private SortOrder ageOrder = SortOrder.unsorted;
    private SortOrder educationLevelOrder = SortOrder.unsorted;
    private CommonUtils util = new CommonUtils();
    public void sortByNames() {
    	ageOrder = SortOrder.unsorted;
    	educationLevelOrder = SortOrder.unsorted;
        
        if (namesOrder.equals(SortOrder.ascending)) {
            setNamesOrder(SortOrder.descending);
        } else {
            setNamesOrder(SortOrder.ascending);
        }
    }
    
    public void sortByAge() {
    	namesOrder = SortOrder.unsorted;
    	educationLevelOrder = SortOrder.unsorted;
        if (ageOrder.equals(SortOrder.ascending)) {
            setAgeOrder(SortOrder.descending);
        } else {
        	setAgeOrder(SortOrder.ascending);
        }
    }
    
	public void sortByEducationLevel() {
		namesOrder = SortOrder.unsorted;
		ageOrder = SortOrder.unsorted;
		if (educationLevelOrder.equals(SortOrder.ascending)) {
			setEducationLevelOrder(SortOrder.descending);
		} else {
			setEducationLevelOrder(SortOrder.ascending);
		}
	}
    
   

	@PostConstruct
    public void init() {
    	
    	students = studentService.getAllStudents();
    }

    public void add() {
    	studentService.saveOrUpdate(student);
        student = new Student();
        students = studentService.getAllStudents();
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
    	this.student = new Student();
        edit = false;
        students = studentService.getAllStudents();

		util.redirectWithGet();
    }

    public void saveEdit() {
    	if(this.student.getName().isEmpty())
    		this.student.setName(beforeEditStudent.getName());
    	if(this.student.getAge() == 0)
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

    public SortOrder getNamesOrder() {
        return namesOrder;
    }
 
    public void setNamesOrder(SortOrder namesOrder) {
        this.namesOrder = namesOrder;
    }
 
    public SortOrder getAgeOrder() {
        return ageOrder;
    }
 
    public void setAgeOrder(SortOrder ageOrder) {
        this.ageOrder = ageOrder;
    }
    
    public SortOrder getEducationLevelOrder() {
		return educationLevelOrder;
	}

	public void setEducationLevelOrder(SortOrder educationLevelOrder) {
		this.educationLevelOrder = educationLevelOrder;
	}

}