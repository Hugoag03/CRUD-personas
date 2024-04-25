package com.pruebaCurso.primeraPruebaSpringBoot.config; // Paquete donde se encuentra la clase

import org.springframework.context.annotation.Configuration; // Importación de la clase Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // Importación de la clase ViewControllerRegistry

@Configuration // Marca la clase como una clase de configuración de Spring
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer { // Definición de la clase WebMvcConfigurer que implementa la interfaz WebMvcConfigurer

    @Override // Indica que el método que sigue es una implementación de un método de la interfaz
    public void addViewControllers(ViewControllerRegistry registry) { // Método para registrar controladores de vista
        registry.addViewController("/403").setViewName("403"); // Registra un controlador de vista para la ruta "/403" y establece la vista asociada como "403"
        registry.addViewController("/login").setViewName("login"); // Registra un controlador de vista para la ruta "/login" y establece la vista asociada como "login"
    }

}
