package org.perryCode.peringbackend.controller;

import java.util.List;

import org.perryCode.peringbackend.entity.Post;
import org.perryCode.peringbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping
	public List<Post> getAllPosts(){
		/* log.info("Solicitud get para todos los Customers"); */
		List<Post> posts = (List<Post>) postRepository.findAll();
		return posts;
	}
	
	@GetMapping("{id}")
	public Post getPostById(@PathVariable long id) {
		Post post = postRepository.findById(id);
		return post;
	}
}
