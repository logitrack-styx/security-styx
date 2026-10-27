package com.logitrack.security.exception;

import java.util.UUID;

public class UsuarioNoEncontradoException extends RuntimeException {
	
	public UsuarioNoEncontradoException(String dato) {
		super("No se encontro el usuario con el username con valor " + dato);
	}
	
	public UsuarioNoEncontradoException(UUID dato) {
		super("No se encontro el usuario con el id con valor " + dato);
	}

}
