package org.perryCode.peringbackend.repository;

import java.util.List;

import org.perryCode.peringbackend.entity.UserHasSoftSkill;
import org.springframework.data.repository.CrudRepository;

public interface UserHasSoftSkillRepository extends CrudRepository<UserHasSoftSkill, Long> {
    
	List<UserHasSoftSkill> findAll();
}
