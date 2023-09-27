package org.perryCode.peringbackend.service;

import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.SoftSkill;


public interface SoftSkillService {
	
	List<SoftSkill> getAllSoftSkills();
	
	Optional<SoftSkill> getSoftSkillById(long id);
	
	SoftSkill setSoftSkill(SoftSkill softSkill);
	
	SoftSkill updateSoftSkill(SoftSkill softSkill, long id);
	
	void deleteSoftSkill(long id);
	
}
