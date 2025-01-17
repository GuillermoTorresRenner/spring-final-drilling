package com.devateleur.estudiantes_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devateleur.estudiantes_api.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    public Optional<Materia> findById(long id);

}
