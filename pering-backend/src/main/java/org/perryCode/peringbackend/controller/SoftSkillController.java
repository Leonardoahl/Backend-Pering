package org.perryCode.peringbackend.controller;
import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.SoftSkill;
import org.perryCode.peringbackend.service.SoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/softSkill")
public class SoftSkillController {

    @Autowired
    private SoftSkillService softSkillService;
    
    @GetMapping
    public ResponseEntity<List<SoftSkill>> getAllSoftSkills() {
    	List<SoftSkill> softSkills = (List<SoftSkill>)softSkillService.getAllSoftSkills();
    	
    	return new ResponseEntity<List<SoftSkill>>(softSkills, HttpStatus.OK);
        
    }
    
    @GetMapping("/{id}")//Solicitud get para soft skill por id
    public ResponseEntity<SoftSkill> getSoftSkillById(@PathVariable long id) {
        Optional<SoftSkill> softSkill = softSkillService.getSoftSkillById(id);
        
        return new ResponseEntity<SoftSkill>(softSkill.get(),HttpStatus.OK);
    }
    


    @DeleteMapping("/{id}")//Solicitud delete para elimirar soft skill por id
    public ResponseEntity<String> deleteSoftSkill(@PathVariable long id) {
    	softSkillService.deleteSoftSkill(id);
    	
        return ResponseEntity.ok("SoftSkill deleted successfully");
    }
    
    
    
}

