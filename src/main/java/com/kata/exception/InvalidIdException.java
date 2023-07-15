package com.kata.exception;

public class InvalidIdException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   public InvalidIdException() {
      super("Invalid  ID");
   }
   
   public InvalidIdException(String message) {
	   super(message);
   }
   
   
}
