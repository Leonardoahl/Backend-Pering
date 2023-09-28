package org.perryCode.peringbackend.controller;

import java.util.List;
import org.perryCode.peringbackend.entity.Post;
import org.perryCode.peringbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Long id) {
		Post post = postService.getPostById(id);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts(){
		List<Post> posts = (List<Post>) postService.getAllPosts();
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
	
	/*
	@CrossOrigin(origins = "*")
	@GetMapping("/hashtag/{fk_hashtag_id}")
	public ResponseEntity<List<Post>> getPostsByHashtagId(@PathVariable Long fk_hashtag_id) {
	    List<Post> posts = postService.getPostsByHashtagId(fk_hashtag_id);
	    if (!posts.isEmpty()) {
	        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	 */
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody Post post){
		Post newPost = postService.createPost(post);
		return new ResponseEntity<Post>(newPost, HttpStatus.CREATED);
	} 

	@CrossOrigin(origins = "*")
	@PostMapping("/{id}/like") 
	public ResponseEntity<Post> addLike(@PathVariable Long id) {
		Post existingPost = postService.getPostById( id );	
		postService.addLikeToPost(existingPost, id);
		return new ResponseEntity<Post>(existingPost, HttpStatus.OK); 
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/{id}/dislike") 
	public ResponseEntity<Post> removeLike(@PathVariable Long id) {
		Post existingPost = postService.getPostById( id );	
		postService.removeLikeToPost(existingPost, id);
		return new ResponseEntity<Post>(existingPost, HttpStatus.OK); 
	 }
	 
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
	}
}
