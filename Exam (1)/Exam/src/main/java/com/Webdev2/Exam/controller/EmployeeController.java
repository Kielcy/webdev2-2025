package com.Webdev2.Exam.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Webdev2.Exam.model.Employee;
import com.Webdev2.Exam.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping
	public String list(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employees/list";
	}

	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/form";
	}

	@PostMapping
	public String create(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "employees/form";
		}
		try {
			employeeRepository.save(employee);
		} catch (DataIntegrityViolationException ex) {
			bindingResult.rejectValue("email", "unique", "Email must be unique");
			return "employees/form";
		}
		return "redirect:/employees";
	}

	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable Long id, Model model) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
		model.addAttribute("employee", employee);
		return "employees/form";
	}

	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "employees/form";
		}
		employee.setId(id);
		try {
			employeeRepository.save(employee);
		} catch (DataIntegrityViolationException ex) {
			bindingResult.rejectValue("email", "unique", "Email must be unique");
			return "employees/form";
		}
		return "redirect:/employees";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		try {
			employeeRepository.deleteById(id);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to delete employee with id " + id);
		}
		return "redirect:/employees";
	}
}


