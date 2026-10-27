package com.logitrack.security.exception;

public class CredencialesInvalidasException extends RuntimeException {

	public CredencialesInvalidasException(String dato) {
		super("El campo ingresado " + dato + " es invalido");
	}
	
}
