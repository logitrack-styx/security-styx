package com.logitrack.security.service.interfaces;

import com.logitrack.security.model.Usuario;

public interface JwtService {
	
	public String generateToken(Usuario user) throws Exception;

}
