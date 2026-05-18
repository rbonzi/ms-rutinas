package com.rutinas.rutinas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EjercicioDTO {
    private String nombreEjercicio;
    private Long series;
    private Long repeticiones;
    private Long descansoSeries;
    private Long duracionSegundos;
    private Double distanciaKm;
}
