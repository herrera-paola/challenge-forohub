package foro.hub.api.domain.topico;

import foro.hub.api.domain.validaciones.ValidadorDeTopico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    @Autowired
    private List<ValidadorDeTopico> validadores;

    public Topico registrar(DatosRegistroTopico datos){
        validadores.forEach(v -> v.validar(datos));

        var topico = new Topico(datos);
        return repository.save(topico);
    }

    public DatosDetalleTopico actualizar(Long id, DatosActualizacionTopico datos){
        var topico = repository.findByIdAndActivoTrue(id).orElseThrow(() -> new EntityNotFoundException());

        if (datos.titulo() != null || datos.mensaje() != null){
            validadores.forEach(v -> v.validar(new DatosRegistroTopico(
                    datos.titulo() != null ? datos.titulo() : topico.getTitulo(),
                    datos.mensaje() != null ? datos.mensaje() : topico.getMensaje(),
                    topico.getAutor(), topico.getCurso()
            )));
        }
        topico.actualizarInformaciones(datos);
        return new DatosDetalleTopico(topico);
    }
}
