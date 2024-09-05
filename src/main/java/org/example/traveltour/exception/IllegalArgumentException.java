package org.example.traveltour.exception;

import lombok.Getter;

@Getter
public class IllegalArgumentException extends  RuntimeException{
    String code;

    public IllegalArgumentException(String message, String code) {
        super(message);
        this.code = code;
    }
}
