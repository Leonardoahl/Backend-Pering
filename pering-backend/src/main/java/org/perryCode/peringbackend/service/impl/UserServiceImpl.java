package org.perryCode.peringbackend.service.impl;

import java.util.List;

import org.perryCode.peringbackend.entity.User;
import org.perryCode.peringbackend.repository.UserRepository;
import org.perryCode.peringbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return  (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Order doses not exist with id "+ id) );
	}

	@Override
	public User createUser(User user) {
		return saveUser(user);
		
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		User existingUser = getUserById(id);
		existingUser.setDescription(user.getDescription());
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setProfilepic(user.getProfilepic());
		existingUser.setLastname(user.getLastname());
		return saveUser(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		userRepository.delete(existingUser);
	}

	@Override
	public User getUserByUsername(String username) {
		 return userRepository.findByUsername(username);
	}


	
	
}
