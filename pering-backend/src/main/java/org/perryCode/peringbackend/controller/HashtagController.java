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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hashtags")
public class HashtagController {

    @Autowired
    private HashtagService hashtagService;

    @GetMapping
    public ResponseEntity<List<Hashtag>> getAllHashtags() {
        List<Hashtag> hashtags = hashtagService.getAllHashtags();
        return ResponseEntity.ok(hashtags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hashtag> getHashtagById(@PathVariable long id) {
        Optional<Hashtag> hashtag = hashtagService.getHashtagById(id);
        return hashtag.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Hashtag> setHashtag(@RequestBody Hashtag hashtag) {
        Hashtag newHashtag = hashtagService.setHashtag(hashtag);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHashtag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hashtag> updateHashtag(@RequestBody Hashtag hashtag, @PathVariable long id) {
        Hashtag updatedHashtag = hashtagService.updateHashtag(hashtag, id);
        return ResponseEntity.ok(updatedHashtag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHashtag(@PathVariable long id) {
        hashtagService.deleteHashtag(id);
        return ResponseEntity.ok("Hashtag deleted successfully");
    }
}
