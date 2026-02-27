package foro.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank(message = "El titulo es obligatorio.") String titulo,
        @NotBlank(message = "El mensaje no puede estar vacio.") String mensaje,
        @NotBlank(message = "El nombre del autor es obligatorio.") String autor,
        @NotBlank(message = "El curso es obligatorio.") String curso) {
}
