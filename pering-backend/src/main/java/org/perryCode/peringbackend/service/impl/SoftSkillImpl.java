package org.perryCode.peringbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.SoftSkill;
import org.perryCode.peringbackend.repository.SoftSkillRepository;
import org.springframework.stereotype.Service;
import org.perryCode.peringbackend.service.SoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SoftSkillImpl implements SoftSkillService{
	
	@Autowired
	SoftSkillRepository softSkillRepository;
	

	@Override
	public List<SoftSkill> getAllSoftSkills() {
		return softSkillRepository.findAll() ;
	}
	

	@Override
	public Optional<SoftSkill> getSoftSkillById(long id) {
		return softSkillRepository.findById(id);
	}

	@Override
	public SoftSkill setSoftSkill(SoftSkill softSkill) {
		return softSkillRepository.save(softSkill);
	}

	@Override
	public SoftSkill updateSoftSkill(SoftSkill softSkill, long id) {
		
		Optional<SoftSkill> existingSoftSkill = softSkillRepository.findById(id);
		
		if(!existingSoftSkill.isPresent()) {
			throw new IllegalStateException("SoftSkill does not exist");
		}
		
		SoftSkill updateSoftSkill = existingSoftSkill.get();
		updateSoftSkill.setName(softSkill.getName());
		
		return softSkillRepository.save(updateSoftSkill);
	}

	@Override
	public void deleteSoftSkill(long id) {
		softSkillRepository.deleteById(id);
		
	}



}
