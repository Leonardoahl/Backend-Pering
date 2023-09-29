package org.perryCode.peringbackend.controller;

import java.util.List;
import java.util.Optional;


import org.perryCode.peringbackend.entity.TechSkill;
import org.perryCode.peringbackend.repository.TechSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tech-skills")
public class TechSkillController {

    @Autowired
    private TechSkillRepository techSkillRepository;

    @GetMapping("{id}")
    public Optional<TechSkill> getSoftSkill(@PathVariable Long id) {
        return techSkillRepository.findById(id);
    }
    
    @GetMapping
    public List<TechSkill> getAllSoftSkills() {
        return (List<TechSkill>) techSkillRepository.findAll();
    }
}
