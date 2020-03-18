package com.techbenchers.mongodb.repository;

import com.techbenchers.mongodb.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
