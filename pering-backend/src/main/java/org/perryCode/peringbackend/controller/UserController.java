package org.perryCode.peringbackend.controller;


import java.util.List;

import org.perryCode.peringbackend.entity.User;
import org.perryCode.peringbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		User customer = userService.getUserById(id);
		
		return new ResponseEntity<User>(customer, HttpStatus.OK);	
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
	    User newUser = userService.createUser(user);
	    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
	    User user = userService.getUserByUsername(loginUser.getUsername());

	    if (user != null && user.getPassword().equals(loginUser.getPassword())) {
	        return ResponseEntity.ok("Login successful");
	    }

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}

	
	
}