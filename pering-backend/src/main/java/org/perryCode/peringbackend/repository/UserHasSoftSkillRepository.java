package org.perryCode.peringbackend.repository;

import java.util.List;

import org.perryCode.peringbackend.entity.UserHasSoftSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserHasSoftSkillRepository extends CrudRepository<UserHasSoftSkill, Long> {
    
	//List<UserHasSoftSkill> findAll();
	
	@Query("SELECT uhs FROM UserHasSoftSkill uhs")
    List<UserHasSoftSkill> getFilteredUserHasSoftSkills();
	
}
