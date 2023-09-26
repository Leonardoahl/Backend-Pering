package org.perryCode.peringbackend.service;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

=======
>>>>>>> d5177efd6758e2aab58fb330c5f688084ab8301b
import org.perryCode.peringbackend.entity.Hashtag;

public interface HashtagService {
	
<<<<<<< HEAD
	List<Hashtag> getAllHashtags();
	
	Optional<Hashtag> getHashtagById(long id);
=======
	Hashtag getAllHashtags();
	
	Hashtag getHashtagById(long id);
>>>>>>> d5177efd6758e2aab58fb330c5f688084ab8301b
	
	Hashtag setHashtag(Hashtag hashtag);
	
	Hashtag updateHashtag(Hashtag hashtag, long id);
	
<<<<<<< HEAD
	void deleteHashtag(long id);
=======
	Hashtag deleteHashtag(long id);
>>>>>>> d5177efd6758e2aab58fb330c5f688084ab8301b
	

}
