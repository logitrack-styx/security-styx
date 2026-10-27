package com.logitrack.security.service.interfaces;

import java.util.UUID;

import com.logitrack.security.dto.request.UsuarioRequest;
import com.logitrack.security.dto.response.UsuarioResponse;

public interface UsuarioService {

	public UsuarioResponse create(UsuarioRequest request);
	
	public UsuarioResponse getCurrentUser(UUID userId);
	
}
