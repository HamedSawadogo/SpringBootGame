package com.mappingbasics.basesmapping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlayerNotFoundExceprion extends RuntimeException{
    public PlayerNotFoundExceprion(String message){
        super(message);
    }
}
