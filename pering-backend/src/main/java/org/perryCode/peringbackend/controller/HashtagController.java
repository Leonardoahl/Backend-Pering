package org.perryCode.peringbackend.controller;
import java.util.List;
import java.util.Optional;
import org.perryCode.peringbackend.entity.Hashtag;

import org.perryCode.peringbackend.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hashtags")
public class HashtagController {

    @Autowired
    private HashtagRepository hashtagRepository;

    
  
    @GetMapping //Solicitud get para todos los hashtags
    public List<Hashtag> getAllHashtags() {
        return (List<Hashtag>) hashtagRepository.findAll();
    }
    
    
    @GetMapping("{id}")//Solicitud get para hashtag por id
    public Optional<Hashtag> getHashtagById(@PathVariable long id) {
    	return hashtagRepository.findById(id);
    }
    
    @PostMapping //Solicitud para agregar un hashtag
    public Hashtag setHashtag(@RequestBody Hashtag hashtag){
    	hashtag.setId(null);
    	Hashtag newHashtag = hashtagRepository.save(hashtag);
    	return newHashtag;
    }
    
    @PutMapping("{id}") //Solicitud put para actualizar hashtag
    public Hashtag updateHashtag(@RequestBody Hashtag hashtag, @PathVariable long id) {

        Optional<Hashtag> existingHashtag = hashtagRepository.findById(id);

        if (!existingHashtag.isPresent()) {
            throw new IllegalStateException("Hashtag does not exist");
        }

        Hashtag updatedHashtag = existingHashtag.get();
        updatedHashtag.setName(hashtag.getName());

        return hashtagRepository.save(updatedHashtag);
    }
	
    @DeleteMapping("{id}")
    public String deleteHashtag(@PathVariable long id) {

        Hashtag hashtagToDelete = hashtagRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Hashtag does not exist"));

        hashtagRepository.delete(hashtagToDelete);

        return "Hashtag Eliminado";
    }
	
}
