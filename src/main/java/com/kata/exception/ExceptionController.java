package com.kata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
   @ExceptionHandler(value = {InvalidIdException.class,NullObjectException.class})
   public ResponseEntity<Object> handleInvalidIdExceptions(RuntimeException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
   }
}
