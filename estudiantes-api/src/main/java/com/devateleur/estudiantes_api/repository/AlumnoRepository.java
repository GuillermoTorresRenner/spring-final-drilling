package com.devateleur.estudiantes_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devateleur.estudiantes_api.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}