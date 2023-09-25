package org.perryCode.peringbackend.service;

import org.perryCode.peringbackend.entity.Hashtag;

public interface HashtagService {
	
	Hashtag getAllHashtags();
	
	Hashtag getHashtagById(long id);
	
	Hashtag setHashtag(Hashtag hashtag);
	
	Hashtag updateHashtag(Hashtag hashtag, long id);
	
	Hashtag deleteHashtag(long id);
	

}
