package foro.hub.api.domain.validaciones;

import foro.hub.api.domain.ValidacionException;
import foro.hub.api.domain.topico.DatosRegistroTopico;
import foro.hub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicosDuplicados implements ValidadorDeTopico{
    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DatosRegistroTopico datos) {

        var existe = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (existe){
            throw new ValidacionException("Ya existe un topico con el mismo titulo y mensaje.");
        }
    }
}
