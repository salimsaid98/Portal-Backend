package com.example.demo.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Datanotfound extends RuntimeException{
    public Datanotfound(Long id){
            super(MessageFormat.format("not found user of this id :{}", id));
    }
}
