package foro.hub.api.domain.validaciones;

import foro.hub.api.domain.ValidacionException;
import foro.hub.api.domain.topico.DatosRegistroTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCamposObligatorios implements ValidadorDeTopico{

    @Override
    public void validar(DatosRegistroTopico datos) {
        if (datos.titulo() == null || datos.titulo().isBlank()){
            throw new ValidacionException("El titulo es obligatorio.");
        }
        if (datos.mensaje() == null || datos.mensaje().isBlank()){
            throw new ValidacionException("El mensaje es obligatorio.");
        }
        if (datos.autor() == null || datos.autor().isBlank()){
            throw new ValidacionException("El autor es obligatorio.");
        }
        if (datos.curso() == null || datos.curso().isBlank()){
            throw new ValidacionException("El curso es obligatorio.");
        }
    }
}
