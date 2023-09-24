package org.perryCode.peringbackend.controller;

import java.util.List;

import org.perryCode.peringbackend.entity.UserHasSoftSkill;
import org.perryCode.peringbackend.repository.UserHasSoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userHasSoftSkill")
public class UserHasSoftSkillController {

    @Autowired
    private UserHasSoftSkillRepository userHasSoftSkillRepository;

    @GetMapping
    public List<UserHasSoftSkill> getAllUserSoftSkills() {
        return userHasSoftSkillRepository.findAll();
    }
    
  
}

    
    
    

