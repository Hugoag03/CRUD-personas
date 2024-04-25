package com.pruebaCurso.primeraPruebaSpringBoot.service; // Paquete donde se encuentra la interfaz

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona; // Importación de la clase Persona
import java.util.List; // Importación de la interfaz List

public interface PersonaService { // Declaración de la interfaz PersonaService

    List<Persona> obtenerTodas(); // Método para obtener todas las personas

    Persona obtenerPorId(Long id); // Método para obtener una persona por su identificador

    Persona crearPersona(Persona persona); // Método para crear una nueva persona

    Persona modificarPersona(Long id, Persona persona); // Método para modificar una persona existente

    void eliminarPersona(Long id); // Método para eliminar una persona por su identificador
}
