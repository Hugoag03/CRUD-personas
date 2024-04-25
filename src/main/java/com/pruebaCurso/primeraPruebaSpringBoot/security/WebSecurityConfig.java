package com.pruebaCurso.primeraPruebaSpringBoot.security; // Paquete donde se encuentra la clase

import com.pruebaCurso.primeraPruebaSpringBoot.service.impl.UserDetailsServiceImpl; // Importación de la clase UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired
import org.springframework.context.annotation.Bean; // Importación de la anotación Bean
import org.springframework.context.annotation.Configuration; // Importación de la anotación Configuration
import org.springframework.security.authentication.AuthenticationManager; // Importación de la clase AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Importación de la clase DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; // Importación de la clase AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Importación de la clase HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // Importación de la anotación EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService; // Importación de la interfaz UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importación de la clase BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain; // Importación de la clase SecurityFilterChain

import javax.sql.DataSource; // Importación de la clase DataSource

@Configuration // Anotación que marca la clase como una clase de configuración de Spring
@EnableWebSecurity // Anotación que habilita la seguridad web de Spring
public class WebSecurityConfig {

    @Bean // Anotación que marca el método como un bean gestionado por Spring
    public UserDetailsService userDetailsService(){ // Método que devuelve una instancia de UserDetailsServiceImpl
        return new UserDetailsServiceImpl(); // Devuelve una instancia de UserDetailsServiceImpl
    }

    @Bean // Anotación que marca el método como un bean gestionado por Spring
    public BCryptPasswordEncoder passwordEncoder(){ // Método que devuelve una instancia de BCryptPasswordEncoder
        return new BCryptPasswordEncoder(); // Devuelve una instancia de BCryptPasswordEncoder
    }

    @Bean // Anotación que marca el método como un bean gestionado por Spring
    public DaoAuthenticationProvider authenticationProvider(){ // Método que devuelve una instancia de DaoAuthenticationProvider
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); // Crea una nueva instancia de DaoAuthenticationProvider
        authenticationProvider.setUserDetailsService(userDetailsService()); // Establece el servicio de detalles del usuario
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // Establece el codificador de contraseñas
        return authenticationProvider; // Devuelve la instancia de DaoAuthenticationProvider configurada
    }

    @Bean // Anotación que marca el método como un bean gestionado por Spring
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception { // Método que devuelve una instancia de AuthenticationManager
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class); // Obtiene el constructor de autenticación del objeto HttpSecurity
        authenticationManagerBuilder.authenticationProvider(authenticationProvider()); // Configura el proveedor de autenticación
        return authenticationManagerBuilder.build(); // Devuelve el administrador de autenticación construido
    }

    @Bean // Anotación que marca el método como un bean gestionado por Spring
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception { // Método que devuelve una instancia de SecurityFilterChain
        httpSecurity.authorizeHttpRequests( // Configura las reglas de autorización para las solicitudes HTTP
                        auth -> auth // Lambda que configura las reglas de autorización
                                .requestMatchers("/personas").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN") // Autoriza las solicitudes a /personas para roles USER, CREATOR, EDITOR y ADMIN
                                .requestMatchers("/personas/nueva").hasAnyAuthority("ADMIN", "CREATOR", "EDITOR") // Autoriza las solicitudes a /personas/nueva para roles ADMIN, CREATOR y EDITOR
                                .requestMatchers("/personas/editar/*").hasAnyAuthority("ADMIN", "EDITOR") // Autoriza las solicitudes a /personas/editar/* para roles ADMIN y EDITOR
                                .requestMatchers("/personas/eliminar/*").hasAnyAuthority("ADMIN") // Autoriza las solicitudes a /personas/eliminar/* para el rol ADMIN
                                .anyRequest().authenticated()) // Autoriza todas las demás solicitudes autenticadas
                .formLogin(form -> form // Configura el formulario de inicio de sesión
                        .loginPage("/login") // Página de inicio de sesión personalizada
                        .permitAll()) // Permite el acceso a la página de inicio de sesión para todos los usuarios
                .logout(l -> l.permitAll()) // Configura el logout permitiendo el acceso para todos los usuarios
                .exceptionHandling(e -> e.accessDeniedPage("/403")); // Configura la página de acceso denegado
        return httpSecurity.build(); // Devuelve la configuración de seguridad construida
    }

}
