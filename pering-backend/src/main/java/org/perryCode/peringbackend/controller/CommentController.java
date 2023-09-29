package org.perryCode.peringbackend.controller;

import java.util.List;

import org.perryCode.peringbackend.entity.Comment;
import org.perryCode.peringbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("")
	List<Comment> getComments(){
		return (List<Comment>) commentService.getAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	Comment getCommentById(@PathVariable long id) {
		return commentService.getCommentById(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("")
	Comment createComment (@RequestBody Comment comment) {
		return commentService.save(comment);
	}
	
	// Aumenta el número de likes +1
	@CrossOrigin(origins = "*")
	@PostMapping("/{id}/like") 
	public ResponseEntity<Comment> addLike(@PathVariable Long id) {
		Comment existingComment = commentService.getCommentById( id );	
		commentService.addLikeToComment(existingComment, id);			
		return new ResponseEntity<Comment>(existingComment, HttpStatus.OK); 
	}
	
	// Aumenta el número de likes +1
	@CrossOrigin(origins = "*")
	@PostMapping("/{id}/dislike") 
	public ResponseEntity<Comment> removeLike(@PathVariable Long id) {
		Comment existingComment = commentService.getCommentById( id );	
		commentService.removeLikeToComment(existingComment, id);			
		return new ResponseEntity<Comment>(existingComment, HttpStatus.OK); 
	}
}
