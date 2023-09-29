package org.perryCode.peringbackend.service;

import java.util.List;

import org.perryCode.peringbackend.entity.Comment;

public interface CommentService {
	
	Comment save(Comment comment);
	Comment getCommentById(long id);
	List <Comment> getAll();
	Comment addLikeToComment(Comment post, Long id);
	Comment removeLikeToComment(Comment post, Long id);
}