package com.pruebaCurso.primeraPruebaSpringBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password("$2a$10$l1hd/7141bC0EfwqlPDzteJUH4AJMMBLidvUwIyqR88mQMEein1bO")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("admin")
                .password("$2a$10$l1hd/7141bC0EfwqlPDzteJUH4AJMMBLidvUwIyqR88mQMEein1bO")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
*/

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/personas").permitAll()
                                .requestMatchers("/personas/nueva").hasAnyRole("ADMIN")
                                .requestMatchers("/personas/editar/*", "/personas/eliminar/*").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
                .logout(l -> l.permitAll())
                .exceptionHandling(e -> e.accessDeniedPage("/403"));
        return httpSecurity.build();
    }


}
