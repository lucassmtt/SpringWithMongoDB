package com.lucassmtt.workshopmongodb.resources;

import com.lucassmtt.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User jown = new User("2", "Jown Greenð", "jown@gmail.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(maria, jown));
        return ResponseEntity.ok().body(users);

    }
}
