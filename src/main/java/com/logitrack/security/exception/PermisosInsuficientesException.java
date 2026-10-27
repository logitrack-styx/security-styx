package com.logitrack.security.exception;

public class PermisosInsuficientesException extends RuntimeException {
	
	public PermisosInsuficientesException() {
		super("No se tiene el nivel de permisos suficientes");
	}

}
