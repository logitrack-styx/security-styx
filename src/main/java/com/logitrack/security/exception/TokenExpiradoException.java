package com.logitrack.security.exception;

public class TokenExpiradoException extends RuntimeException {
	
	public TokenExpiradoException() {
		super("El token ha expirado");
	}

}
