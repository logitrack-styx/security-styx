package com.logitrack.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logitrack.security.dto.request.LoginRequest;
import com.logitrack.security.dto.request.RegisterRequest;
import com.logitrack.security.dto.response.AuthResponse;
import com.logitrack.security.dto.response.UsuarioResponse;
import com.logitrack.security.service.interfaces.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(
	name = "Autenticación",
    description = "Endpoints para el registro de usuarios y la autenticación"
)
public class AuthController {

	private final AuthService authService;
	
	@PostMapping("/register")
	@Operation(
        summary = "Registrar un usuario",
        description = "Registra un nuevo usuario en el sistema utilizando los datos proporcionados."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Usuario registrado correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UsuarioResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "409",
            description = "El usuario ya existe",
            content = @Content
        )
    })
    public ResponseEntity<UsuarioResponse> register(@Valid @RequestBody RegisterRequest request) {
		UsuarioResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    @Operation(
        summary = "Iniciar sesión",
        description = "Autentica al usuario mediante sus credenciales y devuelve la respuesta de autenticación."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Autenticación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = AuthResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Credenciales incorrectas",
            content = @Content
        )
    })
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) throws Exception {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
	
}
