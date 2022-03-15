package com.FYP.Assistant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FYP.Assistant.dao.UserDAO;
import com.FYP.Assistant.entity.User;
import com.FYP.Assistant.error.ErrorResponse;
import com.FYP.Assistant.error.DataNotFoundException;

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
		
		if(user == null)
			throw new DataNotFoundException("User id=" + id + " not found");
		
		return user; 
	}
	
	@GetMapping("/user/details")
	public User getUserByUsernameAndPassword(@RequestParam String name, @RequestParam String password) {
		
		User user = userDAO.findByDetails(name, password);
		
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
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(DataNotFoundException ex){
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}