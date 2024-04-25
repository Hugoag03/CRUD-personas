package com.pruebaCurso.primeraPruebaSpringBoot.service.impl; // Paquete donde se encuentra la clase

import com.pruebaCurso.primeraPruebaSpringBoot.entities.User; // Importación de la clase User
import com.pruebaCurso.primeraPruebaSpringBoot.repository.UserRepository; // Importación de la interfaz UserRepository
import com.pruebaCurso.primeraPruebaSpringBoot.service.MyUserDetails; // Importación de la clase MyUserDetails
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired
import org.springframework.security.core.userdetails.UserDetails; // Importación de la interfaz UserDetails
import org.springframework.security.core.userdetails.UserDetailsService; // Importación de la interfaz UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Importación de la excepción UsernameNotFoundException

public class UserDetailsServiceImpl implements UserDetailsService { // Implementación de la interfaz UserDetailsService

    @Autowired // Inyección de dependencia automática de UserRepository
    private UserRepository userRepository; // Repositorio de usuarios

    @Override // Anotación que indica la anulación de un método
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Método para cargar los detalles de usuario por nombre de usuario
        User user = userRepository.getUserByUsername(username); // Obtiene el usuario por nombre de usuario

        if(user == null){ // Verifica si el usuario no existe
            throw new UsernameNotFoundException("Usuario no encontrado"); // Lanza una excepción si el usuario no es encontrado
        }
        return new MyUserDetails(user); // Retorna los detalles del usuario encapsulados en un objeto MyUserDetails
    }
}
