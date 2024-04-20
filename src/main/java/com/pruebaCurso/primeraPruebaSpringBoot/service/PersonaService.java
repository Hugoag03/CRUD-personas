package com.pruebaCurso.primeraPruebaSpringBoot.service;

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona;

import java.util.List;


public interface PersonaService {

    List<Persona> obtenerTodas();

    Persona obtenerPorId(Long id);

    Persona crearPersona(Persona persona);

    Persona modificarPersona(Long id, Persona persona);

    void eliminarPersona(Long id);


}
