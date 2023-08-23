package com.lucassmtt.workshopmongodb.services;

import com.lucassmtt.workshopmongodb.domain.Post;
import com.lucassmtt.workshopmongodb.repositories.PostRepository;
import com.lucassmtt.workshopmongodb.services.exceptions.ObjectNotFoundException;
import com.mongodb.BasicDBObject;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        if (repository.findById(id).isEmpty()){
            throw new ObjectNotFoundException("Resouce not found");
        }
        return repository.findById(id).get();
    }

    public List<Post> findByTitleContaining(String text) {
        return repository.findByTitleContaining(text);
    }
}
