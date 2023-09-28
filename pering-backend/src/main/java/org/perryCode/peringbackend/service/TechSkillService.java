package org.perryCode.peringbackend.service;

import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.TechSkill;

public interface TechSkillService {
	
	List <TechSkill> getAllTechSkills();
	
    Optional<TechSkill> getTechSkillById(Long id);
	
	TechSkill setTechSkill(TechSkill techSkill);
	
	TechSkill updateTechSkill(TechSkill TechSkill, Long id);
	
	void deleteTechSkill(long id);
	
	

}
