package org.perryCode.peringbackend.service;

import java.util.List;

import org.perryCode.peringbackend.entity.Comment;

public interface CommentService {
	
	Comment save(Comment comment);
	Comment update(Comment comment, long id);
	void delete (long id);
	Comment getById(long id);
	 List <Comment> getAll();
}
