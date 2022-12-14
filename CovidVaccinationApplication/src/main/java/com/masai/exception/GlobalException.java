package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



public class GlobalException {
	//to handel any exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> anyExpHandler(Exception ie , WebRequest rq){
		
	 
	 MyErrorDetails err=new MyErrorDetails();
	 err.setTimestamp(LocalDateTime.now());
	 err.setMessage(ie.getMessage());
	 err.setDetails(rq.getDescription(false));
	 
	 return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	 
	}
 
 public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest rq){
	 
	 MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),nfe.getMessage(),rq.getDescription(false));
	 err.setTimestamp(LocalDateTime.now());
	 err.setMessage(nfe.getMessage());
	 err.setDetails(rq.getDescription(false));
	 
return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	 
	 
 }
 
 //validation exception handler
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<MyErrorDetails> MyInvalidDataExceptionHandler(MethodArgumentNotValidException me) {
	 MyErrorDetails err=new MyErrorDetails();
	 
	 
	 err.setTimestamp(LocalDateTime.now());
	 err.setMessage("Validation error");
	 err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
	 
return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);	 
	 
	 
 }
 
 //member class exception handler
 @ExceptionHandler(MemberException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(MemberException ie , WebRequest rq){
		
	 MyErrorDetails err=new MyErrorDetails();
	 err.setTimestamp(LocalDateTime.now());
	 err.setMessage(ie.getMessage());
	 err.setDetails(rq.getDescription(false));
	 
return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	 
	}
}
