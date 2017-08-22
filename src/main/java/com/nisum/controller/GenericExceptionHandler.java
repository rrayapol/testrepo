package com.nisum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<ExceptionData> handleConflict(RuntimeException ex) {
		ExceptionData ed = new ExceptionData(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());

		return new ResponseEntity<ExceptionData>(ed, HttpStatus.BAD_REQUEST);

	}

	static class ExceptionData {

		String errorMessage;

		String Status;

		ExceptionData(String msg, String status) {
			this.errorMessage = msg;
			this.Status = status;

		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

	}

}
