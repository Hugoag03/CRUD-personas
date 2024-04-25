package com.pruebaCurso.primeraPruebaSpringBoot; // Paquete donde se encuentra la clase

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importación de la clase BCryptPasswordEncoder

public class SecuredPassword { // Declaración de la clase SecuredPassword

    public static void main(String[] args) { // Método principal
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // Creación de una instancia de BCryptPasswordEncoder

        String rawPassword = "password"; // Contraseña sin cifrar
        String encodedPassword = encoder.encode(rawPassword); // Codificación de la contraseña

        System.out.println(encodedPassword); // Imprime la contraseña codificada
    }
}
