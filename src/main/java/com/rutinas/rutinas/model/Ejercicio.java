package com.rutinas.rutinas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ejercicios")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Ejercicio;

    @Column(name = "nombre_ejercicio",nullable = false)
    private String nombreEjercicio;

    @Column(nullable = true)
    private Long series;

    @Column(nullable = true)
    private Long repeticiones;

    @Column(nullable = true)
    private Long descansoSeries;

    @Column(nullable = true)
    private Long duracionSegundos;

    @Column(nullable = true)
    private Double distanciaKm;
}
