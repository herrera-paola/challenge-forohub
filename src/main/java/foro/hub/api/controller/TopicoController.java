package foro.hub.api.controller;

import foro.hub.api.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired TopicoService service;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@Valid @RequestBody DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var detalleTopico = service.registrar(datos);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleTopico.getId()).toUri();
        return ResponseEntity.created(uri).body(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listarTopico(@PageableDefault(size = 10, sort = {"fechaCreacion"}, direction = Sort.Direction.ASC) Pageable pageable){
        var page = repository.findAllByActivoTrue(pageable)
                .map(DatosListaTopico::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var optionalTopico = repository.findByIdAndActivoTrue(id);
        if (optionalTopico.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DatosDetalleTopico(optionalTopico.get()));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos){

        var detalleActualizado = service.actualizar(id, datos);
        return ResponseEntity.ok(detalleActualizado);
    }

//    @Transactional
//    @DeleteMapping("/{id}")
//    public ResponseEntity eliminar(@PathVariable Long id){
//        var optionalTopico = repository.findById(id);
//
//        if (!optionalTopico.isPresent()){
//            return  ResponseEntity.notFound().build();
//        }
//
//        repository.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var optionalTopico = repository.findByIdAndActivoTrue(id);

        if (optionalTopico.isEmpty()){
            return  ResponseEntity.notFound().build();
        }

        var topico = optionalTopico.get();
        topico.eliminar();

        return ResponseEntity.noContent().build();
    }
}
