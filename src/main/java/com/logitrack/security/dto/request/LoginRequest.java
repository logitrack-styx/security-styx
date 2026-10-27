package com.logitrack.security.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Datos necesarios para iniciar sesión")
public class LoginRequest {
	
	@NotBlank
	@Schema(
        description = "Nombre de usuario registrado en el sistema",
        example = "usuario123",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
	private String username;
	
	@NotBlank
	@Schema(
        description = "Contraseña del usuario",
        example = "MiPassword123!",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "password"
    )
	private String password;

}
