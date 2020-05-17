package com.nitesh.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nitesh.pma.dao.EmployeeRepository;
import com.nitesh.pma.dao.ProjectRepository;
import com.nitesh.pma.entites.Employee;
import com.nitesh.pma.entites.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();  // therefore we need an empty constructor
		
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);  // binding
		return "new-project";
	}
	
	@PostMapping("/save")  // we need to have a post method as we are going to access the data of another form.
 	public String createFrom(Project project, @RequestParam List<Long> employees, Model model) {
		// This should handle saving to the database
		proRepo.save(project);
		
		Iterable<Employee> choosenEmployees = empRepo.findAllById(employees);
		
		for(Employee emp: choosenEmployees) {
			emp.setProject(project);
			empRepo.save(emp);
		}
		
		// use direct to prevent duplicate submission
		return "redirect:/";
	}
	
	
	@GetMapping("/")
	public String showProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		return "list-projects";
	}
}
