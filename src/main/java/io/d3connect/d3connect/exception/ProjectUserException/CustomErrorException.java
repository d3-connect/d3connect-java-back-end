package io.d3connect.d3connect.exception.ProjectUserException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomErrorException extends RuntimeException {
    public CustomErrorException(String message) {
        super(message);
    }
}