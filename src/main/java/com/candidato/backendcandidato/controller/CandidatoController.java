package com.candidato.backendcandidato.controller;


import com.candidato.backendcandidato.model.Candidato;
import com.candidato.backendcandidato.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ip")
public class CandidatoController {

    @Autowired
    private CandidatoRepository repository;


    @GetMapping("/")
    public ResponseEntity<List<Candidato>> obtener(){
        return ResponseEntity.ok(repository.finCandidatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> obtenerId(@PathVariable Long id){
        return ResponseEntity.ok(repository.getReferenceById(id));
    }

    @PostMapping("/crear/{id}")
    public ResponseEntity<Candidato> crear(@RequestBody Candidato nuevo) {
        Candidato candidato = repository.save(nuevo);
        return new ResponseEntity<>(candidato, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Candidato> actualizar(@PathVariable long id, @RequestBody Candidato nuevo) {
        Candidato candidato = repository.getReferenceById(id);
        candidato.setNombre(nuevo.getNombre());
        candidato.setEntrevista(nuevo.getEntrevista());
        candidato.setTecnologiaJava(nuevo.getTecnologiaJava());
        candidato.setTecnologiaMicroservicios(nuevo.getTecnologiaMicroservicios());
        candidato.setTecnologiaElastic(nuevo.getTecnologiaElastic());

        repository.save(candidato);
        return ResponseEntity.ok(nuevo);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Long> eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
