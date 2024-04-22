package com.pruebaCurso.primeraPruebaSpringBoot.service.impl;

import com.pruebaCurso.primeraPruebaSpringBoot.entities.User;
import com.pruebaCurso.primeraPruebaSpringBoot.repository.UserRepository;
import com.pruebaCurso.primeraPruebaSpringBoot.service.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if(user == null){
            throw  new UsernameNotFoundException("Usuario no encontrado");
        }
        return new MyUserDetails(user);
    }
}
