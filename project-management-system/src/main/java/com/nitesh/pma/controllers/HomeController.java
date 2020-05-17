package com.nitesh.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nitesh.pma.dao.EmployeeRepository;
import com.nitesh.pma.dao.ProjectRepository;
import com.nitesh.pma.entites.Employee;
import com.nitesh.pma.entites.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String showHome(Model model) {
		List<Project> projects = proRepo.findAll();
 		model.addAttribute("projects", projects);
 		
 		List<Employee> employees = (List<Employee>) empRepo.findAll();
 		model.addAttribute("employee", employees);
 		
		return "home";
	}
	
}
