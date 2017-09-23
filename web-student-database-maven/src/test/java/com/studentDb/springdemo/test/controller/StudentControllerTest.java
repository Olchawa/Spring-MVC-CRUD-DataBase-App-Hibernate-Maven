package com.studentDb.springdemo.test.controller;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.studentDb.springdemo.controller.StudentController;
import com.studentDb.springdemo.entity.Student;
import com.studentDb.springdemo.service.StudentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

public class StudentControllerTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}

	@Test
	public void testList() throws Exception {
		List<Student> students = new ArrayList<>();
		students.add(new Student());
		students.add(new Student());

		when(studentService.getStudents()).thenReturn((List<Student>) students);

		mockMvc.perform(get("/student/list")).andExpect(status().isOk()).andExpect(view().name("list-students"))
				.andExpect(model().attribute("students", hasSize(2)));
		
		when(studentService.getsortedFirstNameStudents()).thenReturn((List<Student>) students);

		mockMvc.perform(get("/student/sortByFirstName")).andExpect(status().isOk()).andExpect(view().name("list-students"))
				.andExpect(model().attribute("students", hasSize(2)));
		
	}

}
