package com.jrwsystems.workshopmongo.repository;

import com.jrwsystems.workshopmongo.domain.Post;
import com.jrwsystems.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
