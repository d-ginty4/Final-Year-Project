package com.FYP.Assistant.rest;

import java.util.ArrayList;
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

import com.FYP.Assistant.dao.QuickNoteDAO;
import com.FYP.Assistant.entity.Job;
import com.FYP.Assistant.entity.QuickNote;

@RestController
public class QuickNoteRestController {

	private QuickNoteDAO quickNoteDAO;
	
	@Autowired
	public QuickNoteRestController(QuickNoteDAO theQuickNoteDAO) {
		quickNoteDAO = theQuickNoteDAO;
	}
	
	@GetMapping("/note")
	public QuickNote getJob(@RequestParam String id) {
		QuickNote note = quickNoteDAO.findById(Integer.parseInt(id));
		
		return note;
	}
	
	@GetMapping("/allNotes")
	public List<QuickNote> findAll(@RequestParam int id){
		
		List<QuickNote> notes = quickNoteDAO.findAll(id);
		
		return notes;
	}
	
	@GetMapping("/projectNotes")
	public List<QuickNote> projectNotes(@RequestParam int projectId){
		
		List<QuickNote> notes = quickNoteDAO.projectNotes(projectId);
		
		return notes;
	}
	
	@PostMapping("/note")
	public QuickNote addNote(@RequestBody QuickNote theNote) {
		quickNoteDAO.save(theNote);
		
		return theNote;
	}
	
	@PutMapping("/note")
	public QuickNote updateUser(@RequestBody QuickNote theQuickNote) {
		quickNoteDAO.save(theQuickNote);
		
		return theQuickNote;
	}
	
	@DeleteMapping("/note")
	public String deleteNote(@RequestParam String id) {
		quickNoteDAO.deletedById(Integer.parseInt(id));
		
		return "Deleted note id - " + id;
	}
}
