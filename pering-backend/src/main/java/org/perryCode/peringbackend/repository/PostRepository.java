package org.perryCode.peringbackend.repository;

import java.util.List;

import org.perryCode.peringbackend.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository< Post, Long > {

	List<Post> findAllByHashtagId(Long fk_hashtag_id);
	
}