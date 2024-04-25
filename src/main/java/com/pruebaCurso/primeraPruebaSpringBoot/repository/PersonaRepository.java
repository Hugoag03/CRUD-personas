package com.pruebaCurso.primeraPruebaSpringBoot.repository; // Paquete donde se encuentra la interfaz

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona; // Importación de la clase Persona
import org.springframework.data.jpa.repository.JpaRepository; // Importación de la interfaz JpaRepository
import org.springframework.stereotype.Repository; // Importación de la anotación Repository

@Repository // Anotación que marca la clase como un componente de repositorio de Spring
public interface PersonaRepository extends JpaRepository<Persona, Long> { // Declaración de la interfaz PersonaRepository, que extiende JpaRepository para la entidad Persona

}
