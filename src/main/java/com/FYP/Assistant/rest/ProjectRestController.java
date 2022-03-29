package com.FYP.Assistant.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FYP.Assistant.dao.ProjectDAO;
import com.FYP.Assistant.entity.Project;

@RestController
public class ProjectRestController {

	private ProjectDAO projectDAO;
	
	@Autowired
	public ProjectRestController(ProjectDAO theProjectDAO) {
		projectDAO = theProjectDAO;
	}
	
	@GetMapping("/project")
	public Project getProject(@RequestParam String id) {
		Project project = projectDAO.findById(Integer.parseInt(id));
		
		return project;
	}
	
	@GetMapping("/userProjects")
	public List<Project> userProjects(@RequestParam int id){
		List<Project> projects = projectDAO.findUserProjects(id);
		
		return projects;
	}
	
	@PostMapping("/project")
	public Project addProject(@RequestBody Project theProject) {
		projectDAO.save(theProject);
		
		return theProject;
	}
	
	@PutMapping("/project")
	public Project updateProject(@RequestBody Project theProject) {
		projectDAO.save(theProject);
		
		return theProject;
	}
	
	@DeleteMapping("/project")
	public String deleteProject(@RequestParam String id) {
		projectDAO.deleteById(Integer.parseInt(id));
		
		return "Deleted project id - " + id;
	}
}
