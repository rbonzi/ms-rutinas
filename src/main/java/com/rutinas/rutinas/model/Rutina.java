package com.rutinas.rutinas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rutinas")
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRutina;

    @Column(nullable = true)
    private String nombreRutina;

    @Column(nullable = true)
    private Long duracionApp;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_Ejercicio_fk",nullable = false)
    private List<Ejercicio> ejercicios;
}
