package org.perryCode.peringbackend.service.impl;

import java.util.List;
import java.util.Optional;


import org.perryCode.peringbackend.entity.TechSkill;
import org.perryCode.peringbackend.repository.TechSkillRepository;
import org.springframework.stereotype.Service;
import org.perryCode.peringbackend.service.TechSkillService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TechSkillImpl implements TechSkillService{
	
	@Autowired
	TechSkillRepository techSkillRepository;

	@Override
	public List<TechSkill> getAllTechSkills() {
		
		return (List<TechSkill>) techSkillRepository.findAll();
	}

	@Override
	public Optional<TechSkill> getTechSkillById(Long id) {
		return techSkillRepository.findById(id);
	}

	@Override
	public TechSkill setTechSkill(TechSkill techSkill) {
		return techSkillRepository.save(null);
	}

	@Override
	public TechSkill updateTechSkill(TechSkill TechSkill, Long id) {
		Optional<TechSkill> existingTechSkill = techSkillRepository.findById(id);
			if(!existingTechSkill.isPresent()) {
				throw new IllegalStateException("TechSkill does not exist");
			}
			TechSkill updateTechSkill = existingTechSkill.get();
			updateTechSkill.setName(TechSkill.getName());
			
		return techSkillRepository.save(updateTechSkill);
	}

	@Override
	public void deleteTechSkill(long id) {
		techSkillRepository.deleteById(id);
	}
	


}
