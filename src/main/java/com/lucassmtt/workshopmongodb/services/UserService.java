package com.lucassmtt.workshopmongodb.services;

import com.lucassmtt.workshopmongodb.domain.User;
import com.lucassmtt.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
