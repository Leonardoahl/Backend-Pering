package org.perryCode.peringbackend.repository;

import java.util.List;

import org.perryCode.peringbackend.entity.TechSkills;
import org.springframework.data.repository.CrudRepository;

public interface TechSkillRepository extends CrudRepository<TechSkills, Long> {
    
	List<TechSkills> findAll();
}