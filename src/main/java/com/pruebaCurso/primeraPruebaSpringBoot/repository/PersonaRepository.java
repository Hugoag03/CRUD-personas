package com.pruebaCurso.primeraPruebaSpringBoot.repository;

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
