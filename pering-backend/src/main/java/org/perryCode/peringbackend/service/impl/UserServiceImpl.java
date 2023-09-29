package org.perryCode.peringbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.perryCode.peringbackend.entity.SoftSkill;
import org.perryCode.peringbackend.entity.TechSkill;
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
	public User updateUser(User user, Long id, List<TechSkill> allTechSkills, List<SoftSkill> allSoftSkill) {
		User existingUser = getUserById(id);
		
		if(!(user.getFirstname() == null)) {
			existingUser.setFirstname(user.getFirstname());
		}
		
		if(!(user.getLastname()  == null)) {
			existingUser.setLastname(user.getFirstname());
		}
		
		if(!(user.getUsername()  == null)) {
			existingUser.setUsername(user.getUsername());
		}
		
		if(!(user.getPassword() == null)) {
			existingUser.setPassword(user.getPassword());
		}
		
		if(!(user.getDescription()  == null)) {
			existingUser.setDescription(user.getDescription());
		}
		
		if(!(user.getProfilepic()  == null)) {
			existingUser.setProfilepic(user.getProfilepic());
		}
		
		if(!(user.getSoftSkills()  == null)) {
			List<SoftSkill> newSofts = new ArrayList<>();
			for(int i =0; i < user.getSoftSkills().size(); i++) {
				for(int j = 0; j<allSoftSkill.size(); j++) {
					if(user.getSoftSkills().get(i).getId() == allSoftSkill.get(j).getId() ){
						newSofts.add(allSoftSkill.get(j));
					}
				}
			}	
			existingUser.setSoftSkills(newSofts);
		}
		
		if(!(user.getTechSkills()  == null)) {
			List<TechSkill> newTechs = new ArrayList<>();
			for(int i =0; i < user.getTechSkills().size(); i++) {
				for(int j = 0; j<allTechSkills.size(); j++) {
					if(user.getTechSkills().get(i).getId() == allTechSkills.get(j).getId() ){
						newTechs.add(allTechSkills.get(j));
					}
				}
			}	
			
			existingUser.setTechSkills(newTechs);
		}
			
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
