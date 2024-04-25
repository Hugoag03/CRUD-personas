package com.pruebaCurso.primeraPruebaSpringBoot.entities; // Paquete donde se encuentra la clase

import jakarta.persistence.*; // Importación de las anotaciones de JPA (Java Persistence API)
import lombok.AllArgsConstructor; // Importación de la anotación lombok para generar un constructor con todos los argumentos
import lombok.Data; // Importación de la anotación lombok para generar automáticamente métodos getter, setter, toString, equals y hashCode
import lombok.NoArgsConstructor; // Importación de la anotación lombok para generar un constructor vacío

@Entity // Marca la clase como una entidad JPA
@Table(name = "tablaPersonas") // Especifica el nombre de la tabla en la base de datos
@AllArgsConstructor // Anotación lombok para generar un constructor con todos los argumentos
@NoArgsConstructor // Anotación lombok para generar un constructor vacío
@Data // Anotación lombok para generar automáticamente métodos getter, setter, toString, equals y hashCode
public class Persona {

    @Id // Indica que esta propiedad es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores para la clave primaria de forma incremental
    private Long id; // Propiedad que representa el identificador único de la persona

    private String nombre; // Propiedad que representa el nombre de la persona

    private int edad; // Propiedad que representa la edad de la persona
}
