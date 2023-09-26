package org.perryCode.peringbackend.service;


import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.Hashtag;

public interface HashtagService {
	

	List<Hashtag> getAllHashtags();
	
	Optional<Hashtag> getHashtagById(long id);
	
	Hashtag setHashtag(Hashtag hashtag);
	
	Hashtag updateHashtag(Hashtag hashtag, long id);
	
	void deleteHashtag(long id);

	

}
