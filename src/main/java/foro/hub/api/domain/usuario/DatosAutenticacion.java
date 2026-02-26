package foro.hub.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosAutenticacion(
        @NotBlank @Email String login,
        @NotBlank @Size(min = 5, max = 10) String contrasena) {
}
