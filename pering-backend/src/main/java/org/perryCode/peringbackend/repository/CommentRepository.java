package org.perryCode.peringbackend.repository;

import org.perryCode.peringbackend.entity.Comment;
import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Comment, Long> {
	
}