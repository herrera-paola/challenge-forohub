package foro.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        String autor,
        String curso) {

    public DatosListaTopico(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
