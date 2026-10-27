package com.logitrack.security.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CredencialesInvalidasException.class)
	public ResponseEntity<ErrorResponse> handleCredencialesInvalidas(CredencialesInvalidasException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.UNAUTHORIZED.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(error);
	}
	
	@ExceptionHandler(PermisosInsuficientesException.class)
	public ResponseEntity<ErrorResponse> handlePermisosInsuficientes(PermisosInsuficientesException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.FORBIDDEN.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.FORBIDDEN)
				.body(error);
	}
	
	@ExceptionHandler(RolInvalidoException.class)
	public ResponseEntity<ErrorResponse> handleRolInvalido(RolInvalidoException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(error);
	}
	
	@ExceptionHandler(TokenExpiradoException.class)
	public ResponseEntity<ErrorResponse> handleTokenExpirado(TokenExpiradoException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.UNAUTHORIZED.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(error);
	}
	
	@ExceptionHandler(TokenInvalidoException.class)
	public ResponseEntity<ErrorResponse> handleTokenInvalido(TokenInvalidoException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.UNAUTHORIZED.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(error);
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public ResponseEntity<ErrorResponse> handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	@ExceptionHandler(UsuarioYaExistenteException.class)
	public ResponseEntity<ErrorResponse> handleUsuarioYaExistente(UsuarioYaExistenteException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				"Credenciales Invalidas",
				ex.getMessage(),
				request.getRequestURI()
		);
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(error);
	}

}
