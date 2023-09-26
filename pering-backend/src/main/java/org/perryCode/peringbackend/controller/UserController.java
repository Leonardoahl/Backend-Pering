package org.perryCode.peringbackend.controller;


import java.util.List;

import org.perryCode.peringbackend.entity.User;
import org.perryCode.peringbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("")
	public List<User> getUserList() {
		List<User> customer = (List<User>) userRepository.findAll();
		System.out.println(customer);
		return customer;	
	}

	@GetMapping("{id}")
	public User getUserById(@PathVariable long id) {
		User customer = userRepository.findById(id);
		System.out.println(customer);
		return customer;	
	}
	
	
}
