package org.perryCode.peringbackend.repository;

import org.perryCode.peringbackend.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository< Post, Long > {
	
}
