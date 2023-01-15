package com.chornobuk.practice5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler{

    @ExceptionHandler(value = { EntityNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(exception.getMessage());
    }

    @ExceptionHandler(value = {CustomIllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCustomIllegalArgumentException(CustomIllegalArgumentException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
