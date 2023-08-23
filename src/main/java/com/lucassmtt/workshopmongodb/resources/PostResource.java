package com.lucassmtt.workshopmongodb.resources;

import com.lucassmtt.workshopmongodb.domain.Post;
import com.lucassmtt.workshopmongodb.resources.util.URL;
import com.lucassmtt.workshopmongodb.services.PostService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
       text = URL.decodeParam(text);
       List<Post> posts = service.findByTitleContaining(text);
       return ResponseEntity.ok().body(posts);
    }
}