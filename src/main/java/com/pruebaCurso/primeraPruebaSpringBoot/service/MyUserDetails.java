package com.pruebaCurso.primeraPruebaSpringBoot.service; // Paquete donde se encuentra la clase

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Role; // Importación de la clase Role
import com.pruebaCurso.primeraPruebaSpringBoot.entities.User; // Importación de la clase User
import lombok.AllArgsConstructor; // Importación de la anotación AllArgsConstructor
import org.springframework.security.core.GrantedAuthority; // Importación de la interfaz GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Importación de la clase SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails; // Importación de la interfaz UserDetails
import java.util.ArrayList; // Importación de la clase ArrayList
import java.util.Collection; // Importación de la interfaz Collection
import java.util.List; // Importación de la clase List
import java.util.Set; // Importación de la clase Set

@AllArgsConstructor // Anotación que genera un constructor con todos los argumentos
public class MyUserDetails implements UserDetails { // Implementación de la interfaz UserDetails

    private User user; // Usuario encapsulado

    @Override // Anotación que indica la anulación de un método
    public Collection<? extends GrantedAuthority> getAuthorities() { // Método para obtener los roles del usuario
        Set<Role> roles = user.getRoles(); // Obtiene los roles del usuario
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(); // Lista de autoridades

        for(Role role : roles){ // Itera sobre los roles del usuario
            authorities.add(new SimpleGrantedAuthority(role.getNombre())); // Agrega cada rol como una autoridad SimpleGrantedAuthority
        }
        return authorities; // Retorna la lista de autoridades
    }

    @Override // Anotación que indica la anulación de un método
    public String getPassword() { // Método para obtener la contraseña del usuario
        return user.getPassword(); // Retorna la contraseña del usuario
    }

    @Override // Anotación que indica la anulación de un método
    public String getUsername() { // Método para obtener el nombre de usuario
        return user.getUsername(); // Retorna el nombre de usuario
    }

    @Override // Anotación que indica la anulación de un método
    public boolean isAccountNonExpired() { // Método que indica si la cuenta no ha expirado
        return true; // Retorna verdadero siempre (no se considera la expiración de la cuenta)
    }

    @Override // Anotación que indica la anulación de un método
    public boolean isAccountNonLocked() { // Método que indica si la cuenta no está bloqueada
        return true; // Retorna verdadero siempre (no se considera el bloqueo de la cuenta)
    }

    @Override // Anotación que indica la anulación de un método
    public boolean isCredentialsNonExpired() { // Método que indica si las credenciales no han expirado
        return true; // Retorna verdadero siempre (no se considera la expiración de las credenciales)
    }

    @Override // Anotación que indica la anulación de un método
    public boolean isEnabled() { // Método que indica si la cuenta está habilitada
        return true; // Retorna verdadero siempre (la cuenta está habilitada)
    }
}
