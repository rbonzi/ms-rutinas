package com.rutinas.rutinas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RutinaDTO {
    private String nombreRutina;
    private Long duracionApp;
    private List<EjercicioDTO> ejercicios;
}
