package org.perryCode.peringbackend.controller;

import java.util.List;

import org.perryCode.peringbackend.entity.UserHasSoftSkill;
import org.perryCode.peringbackend.repository.UserHasSoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userHasSoftSkill")
public class UserHasSoftSkillController {

	  @Autowired
	    private UserHasSoftSkillRepository userHasSoftSkillsRepository;

	    // Endpoint para obtener todos los registros de users_has_soft_skills
	    @GetMapping
	    public List<UserHasSoftSkill> getAllUserSoftSkills() {
	        return userHasSoftSkillsRepository.findAll();
	    }

	    // Endpoint para crear un nuevo registro
	    @PostMapping
	    public UserHasSoftSkill createUserSoftSkills(@RequestBody UserHasSoftSkill userSoftSkills) {
	        return userHasSoftSkillsRepository.save(userSoftSkills);
	    }
    
  
}

    
    
    

