package org.perryCode.peringbackend.service;

import java.sql.Timestamp;
import java.util.List;

import org.perryCode.peringbackend.entity.Post;

public interface PostService {

	List<Post> getAllPosts();
	Post getPostById(Long id);
	// List<Post> getPostsByHashtagId(Long fk_hashtag_id);
	List<Post> getPostsByPublicationDate(Timestamp publicationDate);
	Post createPost(Post post);
	Post addLikeToPost(Post post, Long id);
	Post removeLikeToPost(Post post, Long id);
	String deletePost(Long id);
	
}
