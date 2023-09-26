package org.perryCode.peringbackend.service.impl;

import java.util.List;

import org.perryCode.peringbackend.entity.Comment;
import org.perryCode.peringbackend.repository.CommentRepository;
import org.perryCode.peringbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceimpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Comment update(Comment comment, long id) {
		Comment commentExist = getById(id);
		commentExist.setCommentDate(comment.getCommentDate());
		commentExist.setContent(comment.getContent());
		commentExist.setLikes(comment.getLikes());
		return save( commentExist );
	}

	@Override
	public void delete(long id) {
		Comment comment = getById(id);
		commentRepository.delete(comment);
	}

	@Override
	public Comment getById(long id) {
		return commentRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Order does not exist with id "+ id) );
	}

	@Override
	public List<Comment> getAll() {
		return (List<Comment>) commentRepository.findAll();
	} 
	
	
	
}
