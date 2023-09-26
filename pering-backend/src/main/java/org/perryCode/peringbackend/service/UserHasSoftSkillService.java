package org.perryCode.peringbackend.service;

import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.UserHasSoftSkill;

public interface UserHasSoftSkillService {
	
	 List<UserHasSoftSkill> getAllUserHasSoftSkill();

	 Optional<UserHasSoftSkill> getUserHasSoftSkillById(Long id);
	 
	 void deleteUserHasSoftSkills(Long id);
	
}
