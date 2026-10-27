package com.logitrack.security.service.interfaces;

import com.logitrack.security.dto.request.LoginRequest;
import com.logitrack.security.dto.request.RegisterRequest;
import com.logitrack.security.dto.response.AuthResponse;
import com.logitrack.security.dto.response.UsuarioResponse;

public interface AuthService {
	
	public UsuarioResponse register(RegisterRequest request);
	
	public AuthResponse login(LoginRequest request) throws Exception;

}
