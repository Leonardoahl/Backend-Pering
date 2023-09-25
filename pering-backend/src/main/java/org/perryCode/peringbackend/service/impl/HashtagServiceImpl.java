package org.perryCode.peringbackend.service.impl;

import org.perryCode.peringbackend.entity.Hashtag;
import org.perryCode.peringbackend.repository.HashtagRepository;
import org.perryCode.peringbackend.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HashtagServiceImpl implements HashtagService {
	
	@Autowired
	HashtagRepository hashtagRepository;

	@Override
	public Hashtag getAllHashtags() {
		return getAllHashtags();
	}

	@Override
	public Hashtag getHashtagById(long id) {
		return (Hashtag) hashtagRepository.findAll();
	}

	@Override
	public Hashtag setHashtag(Hashtag hashtag) {
		return setHashtag(hashtag);
	}

	@Override
	public Hashtag updateHashtag(Hashtag hashtag, long id) {
		return updateHashtag(hashtag,id);
	}

	@Override
	public Hashtag deleteHashtag(long id) {
		return deleteHashtag(id);
	}
	
	
	
	
	
	
}
