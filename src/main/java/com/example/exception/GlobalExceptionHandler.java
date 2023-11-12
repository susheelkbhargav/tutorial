package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.message.ResponseMessage;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	}

	@ExceptionHandler(InvalidPageException.class)
	public ResponseEntity<ResponseMessage> handleMaxPageException(InvalidPageException exc) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(exc.getMessage()));
	}
}
