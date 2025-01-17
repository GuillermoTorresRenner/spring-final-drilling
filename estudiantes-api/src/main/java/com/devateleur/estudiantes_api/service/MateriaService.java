package com.devateleur.estudiantes_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devateleur.estudiantes_api.model.Materia;
import com.devateleur.estudiantes_api.repository.MateriaRepository;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }
}
