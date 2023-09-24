package org.perryCode.peringbackend.repository;

import java.util.List;

import org.perryCode.peringbackend.entity.SoftSkill;
import org.springframework.data.repository.CrudRepository;

public interface SoftSkillRepository extends CrudRepository<SoftSkill, Long> {
    
	List<SoftSkill> findAll();
}
