package org.perryCode.peringbackend.controller;


import java.util.List;

import org.perryCode.peringbackend.entity.User;
import org.perryCode.peringbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User loginUser) {
		User tempUser = userService.getUserByUsername(loginUser.getUsername());
		if(tempUser.getPassword().equals(loginUser.getPassword())) {
			System.out.println(tempUser.getPassword() + " == " + loginUser.getPassword());
			return new ResponseEntity<User>(tempUser, HttpStatus.OK);
		}
	    return new ResponseEntity<User>(tempUser, HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user, Long id) {
		userService.updateUser(user, id);
		User updatedUser = userService.getUserById(id);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
