package org.perryCode.peringbackend.repository;

import org.perryCode.peringbackend.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

}
