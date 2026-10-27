package com.logitrack.security.exception;

public class UsuarioYaExistenteException extends RuntimeException {

	public UsuarioYaExistenteException(String atributo, String dato) {
		super("Ya existe el usuario con el " + atributo + " con valor " + dato);
	}
	
}
