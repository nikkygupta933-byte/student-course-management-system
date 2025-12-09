package com.student.crud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.student.crud.entity.Student;
import com.student.crud.repository.StudentRepository;

@Controller
@RequestMapping("/students")

public class StudentController {
	private final StudentRepository studentRepository;
	@Autowired 
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	@GetMapping("/signup")
	public String showSignupForm(Student student) {
		return "add-student";
	}
	@GetMapping("/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("students",studentRepository.findAll());
		return "index";
		}
	@PostMapping("/add")
	public String addStudent( Student student, BindingResult result,Model model) {
		studentRepository.save(student);
		return "redirect:list";
	}
	@GetMapping("/edit/{id}")
	public String showUpdateFORM(@PathVariable("id") long id, Model model) {
		Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid candiae Id:"+id));
		model.addAttribute("student", student);
		return "update-student";
		}
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") long id, Student student,BindingResult result,Model model) {
	studentRepository.save(student);
	model.addAttribute("students",studentRepository.findAll());
	return "index";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable ("id") long id,Model model) {
	Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid candiae Id:"+id));
	studentRepository.delete(student);
	model.addAttribute("students",studentRepository.findAll());
	return "index";
	}	}
