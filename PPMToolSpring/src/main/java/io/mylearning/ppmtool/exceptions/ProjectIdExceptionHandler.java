package io.mylearning.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ProjectIdExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleException(ProjectIdException ex,WebRequest wr){
		
		return new ResponseEntity<Object>(new ProjectIdExceptionResponse(ex.getMessage()),HttpStatus.BAD_REQUEST);
		
	}

}
