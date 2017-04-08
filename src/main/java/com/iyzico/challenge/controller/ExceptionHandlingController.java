package com.iyzico.challenge.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ExceptionHandler(Exception.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception exception) {
		logger.error(new StringBuffer().append("Request: ").append(req.getRequestURL()).append(" raised ").append(exception).toString(), exception);
	}

}
