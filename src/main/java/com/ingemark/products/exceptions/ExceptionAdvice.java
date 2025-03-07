package com.ingemark.products.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

	@ExceptionHandler({ ProductNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleProductNotFound(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(request.getRequestURI(), ex.getMessage(), 404, LocalDateTime.now());
	}

	@ExceptionHandler({ InvalidCodeException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleInvalidCode(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(request.getRequestURI(), ex.getMessage(), 404, LocalDateTime.now());
	}

	@ExceptionHandler({ DuplicateCodeException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleDuplicateCode(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(request.getRequestURI(), ex.getMessage(), 404, LocalDateTime.now());
	}

	@ExceptionHandler({ InvalidPriceException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleInvalidPrice(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(request.getRequestURI(), ex.getMessage(), 404, LocalDateTime.now());
	}

	@ExceptionHandler({ ExchangeRateFetchException.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleExchangeRateFetch(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(request.getRequestURI(), ex.getMessage(), 500, LocalDateTime.now());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleException(Exception ex, HttpServletRequest request) {
		log.error(ex.getMessage());
		return new ErrorResponse(request.getRequestURI(), ex.getMessage(), 500, LocalDateTime.now());
	}
}