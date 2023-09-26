package org.perryCode.peringbackend.controller;

import java.util.List;

import org.perryCode.peringbackend.entity.Comment;
import org.perryCode.peringbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@GetMapping("")
	List<Comment> getComments(){
		return (List<Comment>) service.getAll();
	}
	
	@GetMapping("/{id}")
	Comment getCommentById(@PathVariable long id) {
		return service.getById(id);
	}

}
