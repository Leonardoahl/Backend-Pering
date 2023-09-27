package org.perryCode.peringbackend.controller;
import java.util.List;
import java.util.Optional;
import org.perryCode.peringbackend.entity.Hashtag;
import org.perryCode.peringbackend.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hashtags")
public class HashtagController {

    @Autowired

    private HashtagService hashtagService;

    @GetMapping//Solicitud get para todos los hashtag
    public ResponseEntity<List<Hashtag>> getAllHashtags() {
        List<Hashtag> hashtags = (List<Hashtag>) hashtagService.getAllHashtags();
        
        return new ResponseEntity<List<Hashtag>>(hashtags, HttpStatus.OK);
       
    }

    @GetMapping("/{id}")//Solicitud get para hashtag por id
    public ResponseEntity<Hashtag> getHashtagById(@PathVariable long id) {
    	
        Optional<Hashtag> hashtag = hashtagService.getHashtagById(id);
        
        return new ResponseEntity<Hashtag>(hashtag.get(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")//Solicitud delete para elimirar hashtag por id
    public ResponseEntity<String> deleteHashtag(@PathVariable long id) {
        hashtagService.deleteHashtag(id);
        
        return ResponseEntity.ok("Hashtag deleted successfully");
    }

}
