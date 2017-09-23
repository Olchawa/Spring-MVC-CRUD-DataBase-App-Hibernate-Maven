package com.studentDb.springdemo.test.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.studentDb.springdemo.dao.StudentDAO;
import com.studentDb.springdemo.entity.Student;

import com.studentDb.springdemo.service.StudentServiceImpl;

public class StudentServiceTest {

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;
	@Mock
	private StudentDAO studentDao;

	@Before
	public void init() {
		initMocks(this);

	}

	@Test
	public void testGetStudent() {

		when(studentDao.getStudent(1)).thenReturn((Student) getMeTestStudent());
		Student student = studentServiceImpl.getStudent(1);

		assertNotNull(student);
		assertEquals("Pawel", student.getFirstName());
		assertEquals("Olchawa", student.getLastName());
		assertEquals("pawl.olchawa@gmail.com", student.getEmail());
		assertThat(student.getAge(), equalTo(23));
		assertEquals("Poland", student.getCountry());
		assertEquals("Krakow", student.getCity());
	}

	private Object getMeTestStudent() {
		Student student = new Student();
		student.setId(1);
		student.setFirstName("Pawel");
		student.setLastName("Olchawa");
		student.setEmail("pawl.olchawa@gmail.com");
		student.setAge(23);
		student.setCountry("Poland");
		student.setCity("Krakow");
		return student;
	}

}
