package org.perryCode.peringbackend.controller;

import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.SoftSkill;
import org.perryCode.peringbackend.repository.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/softSkill")
public class SoftSkillController {

    @Autowired
    private SoftSkillRepository softSkillRepository;

    @GetMapping("{id}")
    public Optional<SoftSkill> getSoftSkill(@PathVariable Long id) {
        return softSkillRepository.findById(id);
    }
    
    @GetMapping
    public List<SoftSkill> getAllSoftSkills() {
        return softSkillRepository.findAll();
    }
}

