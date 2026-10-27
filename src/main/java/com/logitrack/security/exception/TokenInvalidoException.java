package com.logitrack.security.exception;

public class TokenInvalidoException extends RuntimeException {

	public TokenInvalidoException() {
		super("El token es invalido");
	}
	
}
