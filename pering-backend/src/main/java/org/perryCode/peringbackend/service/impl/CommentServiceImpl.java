package org.perryCode.peringbackend.service.impl;

import java.util.List;

import org.perryCode.peringbackend.entity.Comment;
import org.perryCode.peringbackend.repository.CommentRepository;
import org.perryCode.peringbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Comment getCommentById(long id) {
		return commentRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Comment does not exist with id "+ id) );
	}

	@Override
	public List<Comment> getAll() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment addLikeToComment(Comment post, Long id) {
		Comment existingComment = getCommentById(id);
		existingComment.setLikes(post.getLikes() + 1);
		return commentRepository.save(existingComment);
	}

	@Override
	public Comment removeLikeToComment(Comment post, Long id) {
		Comment existingComment = getCommentById(id);
		
		if(existingComment.getLikes() > 0) {
			existingComment.setLikes(post.getLikes() - 1);			
		}
		return commentRepository.save(existingComment);
	} 
	
	
	
}