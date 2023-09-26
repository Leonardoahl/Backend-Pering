package org.perryCode.peringbackend.service.impl;

import org.perryCode.peringbackend.entity.Hashtag;
import org.perryCode.peringbackend.repository.HashtagRepository;
import org.perryCode.peringbackend.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HashtagServiceImpl implements HashtagService {

    @Autowired
    HashtagRepository hashtagRepository;

    @Override
    public List<Hashtag> getAllHashtags() {
        return (List<Hashtag>) hashtagRepository.findAll();
    }

    @Override
    public Optional<Hashtag> getHashtagById(long id) {
        return hashtagRepository.findById(id);
    }

    @Override
    public Hashtag setHashtag(Hashtag hashtag) {
        return hashtagRepository.save(hashtag);
    }

    @Override
    public Hashtag updateHashtag(Hashtag hashtag, long id) {
        Optional<Hashtag> existingHashtag = hashtagRepository.findById(id);

        if (!existingHashtag.isPresent()) {
            throw new IllegalStateException("Hashtag does not exist");
        }

        Hashtag updatedHashtag = existingHashtag.get();
        updatedHashtag.setName(hashtag.getName());

        return hashtagRepository.save(updatedHashtag);
    }

    @Override
    public void deleteHashtag(long id) {
        hashtagRepository.deleteById(id);
    }

}
