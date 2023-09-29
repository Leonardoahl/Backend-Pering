package org.perryCode.peringbackend.repository;



import java.util.List;

import org.perryCode.peringbackend.entity.TechSkill;
import org.springframework.data.repository.CrudRepository;

public interface TechSkillRepository extends CrudRepository<TechSkill, Long> {
    
	List<TechSkill> findAll();
}