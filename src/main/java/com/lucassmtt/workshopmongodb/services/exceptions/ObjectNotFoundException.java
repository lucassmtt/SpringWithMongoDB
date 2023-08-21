package com.lucassmtt.workshopmongodb.services.exceptions;

import java.io.Serial;
import java.security.PublicKey;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
