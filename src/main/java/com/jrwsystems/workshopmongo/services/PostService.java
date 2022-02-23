package com.jrwsystems.workshopmongo.services;

import com.jrwsystems.workshopmongo.domain.Post;
import com.jrwsystems.workshopmongo.domain.User;
import com.jrwsystems.workshopmongo.dto.UserDto;
import com.jrwsystems.workshopmongo.repository.PostRepository;
import com.jrwsystems.workshopmongo.repository.UserRepository;
import com.jrwsystems.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

     public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
