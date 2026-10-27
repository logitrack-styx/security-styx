package com.logitrack.security.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Respuesta de autenticación con el token de acceso")
public class AuthResponse {
	
	@Schema(
        description = "Token JWT utilizado para autenticar las solicitudes posteriores",
        example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NSJ9.signature",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
	private String accessToken;
	
	@Schema(
        description = "Tipo de token utilizado para la autenticación",
        example = "Bearer",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
	private String tokenType;
	
}
