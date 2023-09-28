package org.perryCode.peringbackend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.perryCode.peringbackend.entity.Post;
import org.perryCode.peringbackend.repository.PostRepository;
import org.perryCode.peringbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> getAllPosts() {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Post does not exist with id "+ id) );
	}
	
	@Override
	public List<Post> getPostsByHashtagId(Long fk_hashtag_id) {
	    return postRepository.findAllByHashtagId(fk_hashtag_id);
	}
	
	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post addLikeToPost(Post post, Long id) {
		Post existingPost = getPostById(id);
		existingPost.setLikes(post.getLikes() + 1);
		return postRepository.save(existingPost);
	}

	@Override
	public String deletePost(Long id) {
	    if (postRepository.findById(id).isPresent()) {
	        postRepository.deleteById(id);
	        return "Post Eliminado Correctamente";
	    } else {
	        throw new NoSuchElementException("Post not found");
	    }
		
	}

	@Override
	public Post removeLikeToPost(Post post, Long id) {
		Post existingPost = getPostById(id);
		if(existingPost.getLikes() > 0) {
			existingPost.setLikes(post.getLikes() - 1);			
		}
		
		return postRepository.save(existingPost);
	}

}
