package org.perryCode.peringbackend.controller;

import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.UserHasSoftSkill;
import org.perryCode.peringbackend.service.UserHasSoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userHasSoftSkill")
public class UserHasSoftSkillController {

	  @Autowired
	    private UserHasSoftSkillService userHasSoftSkillsService;
	  
	  
	  @GetMapping//Solicitud get para userHasSoftSkill (all)
	    public ResponseEntity<List<UserHasSoftSkill>> getAllUserHasSoftSkill() {
	    	List<UserHasSoftSkill> userHasSoftSkills = (List<UserHasSoftSkill>)userHasSoftSkillsService.getAllUserHasSoftSkill();
	        return ResponseEntity.ok(userHasSoftSkills);
	    }
	  
	    
	  
	  @GetMapping("/{id}")//Solicitud get para userHasSoftSkill por id
	    public ResponseEntity<UserHasSoftSkill> getSoftSkillById(@PathVariable long id) {
	        Optional<UserHasSoftSkill> userHasSoftSkill = userHasSoftSkillsService.getUserHasSoftSkillById(id);
	        return userHasSoftSkill.map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	  
	    
	  @DeleteMapping("/{id}")//Solicitud delete para eliminar userHasSoftSkill por id
	  public ResponseEntity<String> deleteSoftSkill(@PathVariable long id) {
		  	userHasSoftSkillsService.deleteUserHasSoftSkills(id);
	        return ResponseEntity.ok("SoftSkill deleted successfully");
	    }
	    
	 
    
  
}

    
    
    

