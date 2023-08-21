package com.lucassmtt.workshopmongodb.dto;

import com.lucassmtt.workshopmongodb.domain.User;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
