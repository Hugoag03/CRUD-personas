package com.pruebaCurso.primeraPruebaSpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "tablaPersonas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int edad;
}
