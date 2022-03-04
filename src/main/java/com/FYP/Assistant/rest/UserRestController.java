package com.FYP.Assistant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FYP.Assistant.dao.UserDAO;
import com.FYP.Assistant.entity.User;

@RestController
public class UserRestController {

	private UserDAO userDAO;
	
	@Autowired
	public UserRestController(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	
	@GetMapping("/user")
	public User getUser(@RequestParam String id) {
		
		User user = userDAO.findById(Integer.parseInt(id));
		
		return user; 
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User theUser) {
		
		userDAO.save(theUser);
		
		return theUser;
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User theUser) {
		
		userDAO.save(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/user")
	public String deleteUser(@RequestParam String id) {
		userDAO.deleteById(Integer.parseInt(id));
		
		return "Deleted user id - " + id;
	}
}
