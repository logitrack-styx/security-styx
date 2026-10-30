package com.logitrack.security.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logitrack.security.dto.request.UsuarioRequest;
import com.logitrack.security.dto.response.UsuarioResponse;
import com.logitrack.security.service.interfaces.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(
    name = "Usuarios",
    description = "Operaciones de administración y consulta de usuarios"
)
@SecurityRequirement(name = "bearerAuth")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@PostMapping
    @PreAuthorize("hasRole('ADMIN')")
	@Operation(
        summary = "Crear un usuario",
        description = "Registra un usuario nuevo. Requiere autenticación y el rol ADMIN."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Usuario creado correctamente",
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
            responseCode = "401",
            description = "No autenticado",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "403",
            description = "No tiene permisos de administrador",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "409",
            description = "El usuario ya existe",
            content = @Content
        )
    })
	public ResponseEntity<UsuarioResponse> create(@Valid @RequestBody UsuarioRequest request) {
		UsuarioResponse response = usuarioService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	
	@GetMapping("/me")
	@Operation(
        summary = "Consultar el usuario autenticado",
        description = "Obtiene los datos del usuario correspondiente al identificador contenido en el JWT."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Usuario consultado correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UsuarioResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Token ausente, inválido o expirado",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado",
            content = @Content
        )
    })
	public ResponseEntity<UsuarioResponse> getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
	    UUID userId = UUID.fromString(jwt.getSubject());
	    return ResponseEntity.ok(usuarioService.getCurrentUser(userId));
	}

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioResponse> getById(
            @org.springframework.web.bind.annotation.PathVariable UUID id) {
        return ResponseEntity.ok(usuarioService.getCurrentUser(id));
    }
}
