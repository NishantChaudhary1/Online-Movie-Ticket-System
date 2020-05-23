package com.sprint.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookingNotFound.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleException(BookingNotFound ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);
		ResponseEntity<ErrorInfo> re = new ResponseEntity<ErrorInfo>(obj, HttpStatus.NOT_FOUND);
		return re;
	}

	@ExceptionHandler(MovieNotFound.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleMovieNotFoundException(MovieNotFound ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);
		ResponseEntity<ErrorInfo> re = new ResponseEntity<ErrorInfo>(obj, HttpStatus.NOT_FOUND);
		return re;
	}

	@ExceptionHandler(MovieAlreadyPresent.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleMovieAlreadyPresentException(MovieAlreadyPresent ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);
		ResponseEntity<ErrorInfo> re = new ResponseEntity<ErrorInfo>(obj, HttpStatus.CONFLICT);
		return re;
	}
	
	@ExceptionHandler(CityNotFound.class)
	public @ResponseBody ResponseEntity<ErrorInfo>  handleException(CityNotFound ex,HttpServletRequest req)
	{
		
		 String message=ex.getMessage();
		 String uri= req.getRequestURI();
		 
		 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
		 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
		 return re;
	}
	@ExceptionHandler(TheaterNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleTheaterNotFoundException(TheaterNotFoundException ex, HttpServletRequest req){
		
		 String message=ex.getMessage();
		 String uri= req.getRequestURI();
		 
		 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
		 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
		 return re;
		
	}
	
	@ExceptionHandler(ShowNotFound.class)
	public @ResponseBody ResponseEntity<ErrorInfo>  handleException(ShowNotFound ex,HttpServletRequest req)
	{
		
		 String message=ex.getMessage();
		 String uri= req.getRequestURI();
		 
		 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
		 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
		 return re;
	}

}