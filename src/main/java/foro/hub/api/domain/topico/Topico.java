package foro.hub.api.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean activo;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    private String autor;
    private String curso;

    public Topico(@Valid DatosRegistroTopico datos) {
        this.activo = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = StatusTopico.ABIERTO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null){
            this.curso = datos.curso();
        }
    }

    public void eliminar(){
        this.activo = false;
    }
}
