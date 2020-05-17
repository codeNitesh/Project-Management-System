package com.nitesh.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nitesh.pma.dao.EmployeeRepository;
import com.nitesh.pma.entites.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model, Employee employee) {
		model.addAttribute("employee", employee);
		return "new-employee";
	}
//  these is no need of displayEmployeeForm, to be in JSON format 	

	
	//HTML ----->
	@PostMapping("/save")
	public String saveForm(Employee employee) {
		empRepo.save(employee);
		return "redirect:/";
	}
	
	
	//HTML ---->
	@GetMapping("/")
	public String showEmployees(Model model) {
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		model.addAttribute("employee", employees);
		return "/list-employees";
	}
	
	
//	// JSON ---->
//	@GetMapping("/")
//	public List<Employee> showEmployees(){
//		return (List<Employee>) empRepo.findAll();
//	}
	
	
//	//JSON---->
//	@PostMapping("/save")
//	public Employee savaFrom(@RequestBody Employee employee) {	
//		return this.empRepo.save(employee);
//	}
}
