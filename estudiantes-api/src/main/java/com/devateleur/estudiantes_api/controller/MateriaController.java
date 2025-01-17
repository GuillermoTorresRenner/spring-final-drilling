package com.devateleur.estudiantes_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.devateleur.estudiantes_api.model.Materia;
import com.devateleur.estudiantes_api.service.MateriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @PostMapping
    public ResponseEntity<Materia> save(@RequestBody Materia materia) {
        materiaService.save(materia);
        return ResponseEntity.ok(materia);
    }

}
