package com.lucassmtt.workshopmongodb.services;

import com.lucassmtt.workshopmongodb.domain.User;
import com.lucassmtt.workshopmongodb.dto.UserDTO;
import com.lucassmtt.workshopmongodb.repositories.UserRepository;
import com.lucassmtt.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        else {
            throw new ObjectNotFoundException("Object not found...");
        }
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User newObj){
        User oldObj = findById(newObj.getId());
        updateData(newObj, oldObj);
        return repository.save(oldObj);
    }

    private void updateData(User newObj, User oldObj) {
        oldObj.setEmail(newObj.getEmail());
        oldObj.setName(newObj.getName());
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
