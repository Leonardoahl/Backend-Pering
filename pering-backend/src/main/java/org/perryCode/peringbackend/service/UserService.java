package org.perryCode.peringbackend.service;

import java.util.List;

import org.perryCode.peringbackend.entity.SoftSkill;
import org.perryCode.peringbackend.entity.TechSkill;
import org.perryCode.peringbackend.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUserById(Long id);
	User createUser(User user);
	User updateUser(User user, Long id, List<TechSkill> allTechSkills, List<SoftSkill> allSoftSkill);
	void deleteUser(Long id);
	User getUserByUsername(String username);
	
	
}
