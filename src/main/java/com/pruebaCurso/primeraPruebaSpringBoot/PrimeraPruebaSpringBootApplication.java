package com.pruebaCurso.primeraPruebaSpringBoot; // Paquete donde se encuentra la clase

import com.pruebaCurso.primeraPruebaSpringBoot.service.PersonaService; // Importación de la interfaz PersonaService
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired
import org.springframework.boot.SpringApplication; // Importación de la clase SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importación de la anotación SpringBootApplication

@SpringBootApplication // Anotación que combina @Configuration, @EnableAutoConfiguration y @ComponentScan
public class PrimeraPruebaSpringBootApplication { // Clase principal de la aplicación

    public static void main(String[] args) { // Método principal que arranca la aplicación Spring Boot
        SpringApplication.run(PrimeraPruebaSpringBootApplication.class, args); // Inicia la aplicación Spring Boot
    }
}
