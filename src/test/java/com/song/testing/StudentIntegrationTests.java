package com.song.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.jsf.example.Student;
import com.song.jsf.example.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentIntegrationTests {
	
	private static final Logger LOGGER = Logger.getLogger(StudentIntegrationTests.class.getName());
	
	private Student student;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void checkEducationLevelByTestData1() {
    	
    	student = new Student();
    	student.setId(1L);
    	student.setAge(13);
    	student.setName("test1");
    	Long studentId = student.getId();
    	studentRepository.save(student);
    	
        Optional<Student> student1 = studentRepository.findById(studentId);
        if(student1.isPresent()) {
        	assertThat(student1.get().getEducationLevel().contentEquals("Elementary"));
        } 
    }
    
    
    @Test
    public void checkEducationLevelByTestData2() {
    	
    	  student = new Student();
    	  student.setId(1L);
      	  student.setAge(13);
      	  student.setName("test1");
    	  
    	  studentRepository.save(student);
    	  Optional<Student> student2 = studentRepository.findById(2L);
		  if(student2.isPresent()) {
		  assertThat(student2.get().getEducationLevel().contentEquals("Elementary")); 
		  }
	}
    
    @Test
    public void checkEducationLevelByTestData3() {
    	
    	  student = new Student();
  	  	  student.setId(3L);
    	  student.setAge(16);
    	  student.setName("test3");  
    	  studentRepository.save(student);
		  Optional<Student> student3 = studentRepository.findById(3L);
		  if(student3.isPresent()) {
		  assertThat(student3.get().getEducationLevel().contentEquals("Secondary")); }
		  
		 
	}
    
    @Test
    public void checkEducationLevelByTestData4() {
    	
    	  student = new Student();
    	  student.setId(4L);
      	  student.setAge(17);
      	  student.setName("test4");
      	  studentRepository.save(student);
		  Optional<Student> student4 = studentRepository.findById(4L);
		  if(student4.isPresent()) {
		  assertThat(student4.get().getEducationLevel().contentEquals("Secondary")); }
		  
		 
	}
    
    @Test
    public void checkEducationLevelByTestData5() {
    	
    	  student = new Student();
    	  student.setId(5L);
      	  student.setAge(22);
      	  student.setName("test5");
      	  studentRepository.save(student);
		  Optional<Student> student5 = studentRepository.findById(5L);
		  if(student5.isPresent()) {
		  assertThat(student5.get().getEducationLevel().contentEquals("Secondary")); }
		  
		  
	}
    
    @Test
    public void checkEducationLevelByTestData6() {
    	
    	  student = new Student();
    	  student.setId(6L);
      	  student.setAge(23);
      	  student.setName("test6");
      	  studentRepository.save(student);
		  Optional<Student> student6 = studentRepository.findById(6L);
		  if(student6.isPresent()) {
		  assertThat(student6.get().getEducationLevel().contentEquals("Higher")); }
		
	}
    
    @Test
    public void checkEducationLevelByTestData7() {
    	
    	  student = new Student();
    	  student.setId(7L);
      	  student.setAge(30);
      	  student.setName("test7");
    	  studentRepository.save(student);
		  Optional<Student> student7 = studentRepository.findById(7L);
		  if(student7.isPresent()) {
		  assertThat(student7.get().getEducationLevel().contentEquals("Higher")); 
		  }
	}
    
	
	@Test
	public void checkEducationLevelByTestData8() {
		try {
			student = new Student();
			student.setId(8L);
			student.setAge(12);
			student.setName("test8");
			studentRepository.save(student);
			assertThat(false);
		} catch (Exception e) {
			assertThat(true);
			LOGGER.info("error message:::" + e.getMessage());
		}

	}
	 
    

}
