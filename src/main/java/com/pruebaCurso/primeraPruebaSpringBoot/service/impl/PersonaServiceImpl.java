package com.pruebaCurso.primeraPruebaSpringBoot.service.impl; // Paquete donde se encuentra la clase

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona; // Importación de la clase Persona
import com.pruebaCurso.primeraPruebaSpringBoot.repository.PersonaRepository; // Importación de la interfaz PersonaRepository
import com.pruebaCurso.primeraPruebaSpringBoot.service.PersonaService; // Importación de la interfaz PersonaService
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired
import org.springframework.stereotype.Service; // Importación de la anotación Service

import java.util.List; // Importación de la interfaz List

@Service // Anotación que marca la clase como un servicio de Spring
public class PersonaServiceImpl implements PersonaService { // Implementación de la interfaz PersonaService

    @Autowired // Inyección de dependencia automática de PersonaRepository
    private PersonaRepository personaRepository; // Repositorio de personas

    @Override // Anotación que indica la anulación de un método
    public List<Persona> obtenerTodas() { // Método para obtener todas las personas
        return personaRepository.findAll(); // Retorna todas las personas almacenadas en la base de datos
    }

    @Override // Anotación que indica la anulación de un método
    public Persona obtenerPorId(Long id) { // Método para obtener una persona por su identificador
        return personaRepository.findById(id).orElse(null); // Retorna la persona con el identificador especificado, si existe
    }

    @Override // Anotación que indica la anulación de un método
    public Persona crearPersona(Persona persona) { // Método para crear una nueva persona
        return personaRepository.save(persona); // Guarda la nueva persona en la base de datos y la retorna
    }

    @Override // Anotación que indica la anulación de un método
    public Persona modificarPersona(Long id, Persona persona) { // Método para modificar una persona existente
        Persona personaBBDD = personaRepository.findById(id).orElse(null); // Obtiene la persona existente por su identificador

        if (personaBBDD != null) { // Verifica si la persona existe
            personaBBDD.setNombre(persona.getNombre()); // Actualiza el nombre de la persona
            personaBBDD.setEdad(persona.getEdad()); // Actualiza la edad de la persona
            return personaRepository.save(personaBBDD); // Guarda los cambios en la base de datos y retorna la persona modificada
        }
        return null; // Retorna nulo si la persona no existe
    }

    @Override // Anotación que indica la anulación de un método
    public void eliminarPersona(Long id) { // Método para eliminar una persona por su identificador
        personaRepository.deleteById(id); // Elimina la persona con el identificador especificado de la base de datos
    }
}
