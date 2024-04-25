package com.pruebaCurso.primeraPruebaSpringBoot.repository; // Paquete donde se encuentra la interfaz

import com.pruebaCurso.primeraPruebaSpringBoot.entities.User; // Importación de la clase User
import org.springframework.data.jpa.repository.JpaRepository; // Importación de la interfaz JpaRepository
import org.springframework.data.jpa.repository.Query; // Importación de la anotación Query
import org.springframework.data.repository.query.Param; // Importación de la anotación Param
import org.springframework.stereotype.Repository; // Importación de la anotación Repository

@Repository // Anotación que marca la clase como un componente de repositorio de Spring
public interface UserRepository extends JpaRepository<User, Long> { // Declaración de la interfaz UserRepository, que extiende JpaRepository para la entidad User

    @Query("SELECT u FROM User u WHERE u.username = :username") // Consulta personalizada JPQL para seleccionar un usuario por nombre de usuario
    User getUserByUsername(@Param("username") String username); // Método que recibe un nombre de usuario como parámetro y devuelve el usuario correspondiente
}
