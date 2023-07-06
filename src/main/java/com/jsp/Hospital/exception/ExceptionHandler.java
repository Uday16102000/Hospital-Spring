package com.jsp.Hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.Hospital.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends  ResponseEntityExceptionHandler
{
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> getExecution(IdNotFoundException ex)
	{
		
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData(ex.getMessage());		
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
}
