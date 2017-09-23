package com.studentDb.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentDb.springdemo.entity.Student;
import com.studentDb.springdemo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String listStudents(Model theModel) {

		List<Student> theStudents = studentService.getStudents();
		theModel.addAttribute("students", theStudents);
		return "list-students";
	}

	@GetMapping("sortByFirstName")
	public String sortByFirstName(Model theModel) {

		List<Student> theStudents = studentService.getsortedFirstNameStudents();
		theModel.addAttribute("students", theStudents);
		return "list-students";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {

		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "student-form";
		} else {
			studentService.saveStudent(theStudent);
			return "redirect:/student/list";
		}
	}

	@GetMapping("/studentUpdateForm")
	public String studentUpdateForm(@RequestParam("studentId") int theId, Model theModel) {

		Student theStudent = studentService.getStudent(theId);
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		studentService.deleteStudent(theId);
		return "redirect:/student/list";
	}

}
