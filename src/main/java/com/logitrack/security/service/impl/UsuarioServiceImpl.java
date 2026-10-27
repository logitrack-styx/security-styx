package com.logitrack.security.service.impl;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logitrack.security.dto.request.UsuarioRequest;
import com.logitrack.security.dto.response.UsuarioResponse;
import com.logitrack.security.exception.UsuarioNoEncontradoException;
import com.logitrack.security.exception.UsuarioYaExistenteException;
import com.logitrack.security.model.Usuario;
import com.logitrack.security.repository.UsuarioRepository;
import com.logitrack.security.service.interfaces.UsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UsuarioResponse create(UsuarioRequest request) {
		if (usuarioRepository.existsByUsername(request.getUsername())) {
	        throw new UsuarioYaExistenteException("username", request.getUsername());
	    }

	    if (usuarioRepository.existsByEmail(request.getEmail())) {
	        throw new UsuarioYaExistenteException("email", request.getEmail());
	    }

		Usuario usuario = Usuario.builder()
	    		.username(request.getUsername())
	    		.email(request.getEmail())
	    		.password(passwordEncoder.encode(request.getPassword()))
	    		.role(request.getRole())
	    		.eneable(true)
	    		.build();

		usuario = usuarioRepository.save(usuario);
		
		log.info("Se ha creado el Usuario: " + usuario.getId());
	    return mapToResponse(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
    public UsuarioResponse getCurrentUser(UUID userId) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> {
                	log.info("No se ha encontrado el Usuario: " + userId);
                	return new UsuarioNoEncontradoException(userId);
                });

		log.info("Se ha encontrado el Usuario: " + userId);
		return mapToResponse(usuario);
    }

	private UsuarioResponse mapToResponse(Usuario usuario) {
		return UsuarioResponse.builder()
				.id(usuario.getId())
				.username(usuario.getUsername())
				.email(usuario.getEmail())
				.role(usuario.getRole())
				.eneable(usuario.isEneable())
				.build();
	}
	
}
