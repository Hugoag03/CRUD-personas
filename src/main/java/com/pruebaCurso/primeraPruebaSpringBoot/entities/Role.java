package com.pruebaCurso.primeraPruebaSpringBoot.entities; // Paquete donde se encuentra la clase

import jakarta.persistence.*; // Importación de las anotaciones de JPA (Java Persistence API)
import lombok.Data; // Importación de la anotación lombok para generar automáticamente métodos getter, setter, toString, equals y hashCode

@Data // Anotación lombok para generar automáticamente métodos getter, setter, toString, equals y hashCode
@Entity // Marca la clase como una entidad JPA
@Table(name = "roles") // Especifica el nombre de la tabla en la base de datos
public class Role {

    @Id // Indica que esta propiedad es la clave primaria
    @Column(name = "role_id") // Especifica el nombre de la columna en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores para la clave primaria de forma incremental
    private Long id; // Propiedad que representa el identificador único del rol

    private String nombre; // Propiedad que representa el nombre del rol
}
