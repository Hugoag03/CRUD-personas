package com.pruebaCurso.primeraPruebaSpringBoot.entities; // Paquete donde se encuentra la clase

import jakarta.persistence.*; // Importación de las anotaciones de JPA (Java Persistence API)
import lombok.Data; // Importación de la anotación lombok para generar automáticamente métodos getter, setter, toString, equals y hashCode

import java.util.HashSet; // Importación de la clase HashSet
import java.util.Set; // Importación de la interfaz Set

@Entity // Marca la clase como una entidad JPA
@Table(name = "users") // Especifica el nombre de la tabla en la base de datos
@Data // Anotación lombok para generar automáticamente métodos getter, setter, toString, equals y hashCode
public class User {

    @Id // Indica que esta propiedad es la clave primaria
    @Column(name = "user_id") // Especifica el nombre de la columna en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores para la clave primaria de forma incremental
    private Long id; // Propiedad que representa el identificador único del usuario

    private String username; // Propiedad que representa el nombre de usuario
    private String password; // Propiedad que representa la contraseña del usuario
    private boolean enabled; // Propiedad que representa si el usuario está habilitado o no

    //private String role; // Comentado: Anteriormente, la relación era de uno a uno con un solo rol

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Mapeo de relación muchos a muchos con roles
    @JoinTable( // Especifica la tabla de unión entre usuarios y roles
            name = "users_roles", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "user_id"), // Columna que hace referencia a la entidad User
            inverseJoinColumns = @JoinColumn(name = "role_id") // Columna que hace referencia a la entidad Role
    )
    private Set<Role> roles = new HashSet<>(); // Conjunto de roles asociados al usuario
}
