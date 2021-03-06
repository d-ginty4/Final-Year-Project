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

import com.FYP.Assistant.dao.JobDAO;
import com.FYP.Assistant.entity.Job;
import com.FYP.Assistant.entity.QuickNote;

@RestController
public class JobRestController {

	private JobDAO jobDAO;
	
	@Autowired
	public JobRestController(JobDAO theJobDAO) {
		jobDAO = theJobDAO;
	}
	
	@GetMapping("/job")
	public Job getJob(@RequestParam String id) {
		Job job = jobDAO.findById(Integer.parseInt(id));
		
		return job;
	}
	
	@GetMapping("/userJobs")
	public List<Job> userJobs(@RequestParam int id, @RequestParam String date){
		List<Job> jobs = jobDAO.findJobs(id, date);
		
		return jobs;
	}
	
	@GetMapping("/projectJobs")
	public List<Job> projectNotes(@RequestParam int projectId){
		
		List<Job> jobs = jobDAO.projectJobs(projectId);
		
		return jobs;
	}
	
	@PostMapping("/job")
	public Job addJob(@RequestBody Job theJob) {
		
		jobDAO.save(theJob);
		
		return theJob;
	}
	
	@PutMapping("/job")
	public Job updateJob(@RequestBody Job theJob) {
		jobDAO.save(theJob);
		
		return theJob;
	}
	
	@DeleteMapping("/job")
	public String deleteJob(@RequestParam String id) {
		jobDAO.deleteById(Integer.parseInt(id));
		
		return "Deleted job id - " + id;
	}
}
