package com.pruebaCurso.primeraPruebaSpringBoot;

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona;
import com.pruebaCurso.primeraPruebaSpringBoot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeraPruebaSpringBootApplication {

	@Autowired
	private PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(PrimeraPruebaSpringBootApplication.class, args);
	}

/*
	@Override
	public void run(String... args) throws Exception {
		personaService.crearPersona(new Persona(1L, "Juan", 20));
		personaService.crearPersona(new Persona(2L, "Pedro", 23));
	}

 */
}
