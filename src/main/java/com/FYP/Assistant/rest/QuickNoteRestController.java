package com.FYP.Assistant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FYP.Assistant.dao.QuickNoteDAO;
import com.FYP.Assistant.entity.QuickNote;

@RestController
public class QuickNoteRestController {

	private QuickNoteDAO quickNoteDAO;
	
	@Autowired
	public QuickNoteRestController(QuickNoteDAO theQuickNoteDAO) {
		quickNoteDAO = theQuickNoteDAO;
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
