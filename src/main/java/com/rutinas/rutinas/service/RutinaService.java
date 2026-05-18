package com.rutinas.rutinas.service;

import com.rutinas.rutinas.dto.EjercicioDTO;
import com.rutinas.rutinas.dto.RutinaDTO;
import com.rutinas.rutinas.model.Ejercicio;
import com.rutinas.rutinas.model.Rutina;
import com.rutinas.rutinas.repository.RutinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RutinaService {
    private final RutinaRepository rutinaRepository;

    private Ejercicio mapearEjercicio(EjercicioDTO dto) {
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombreEjercicio(dto.getNombreEjercicio());
        ejercicio.setSeries(dto.getSeries());
        ejercicio.setRepeticiones(dto.getRepeticiones());
        ejercicio.setDescansoSeries(dto.getDescansoSeries());
        ejercicio.setDuracionSegundos(dto.getDuracionSegundos());
        ejercicio.setDistanciaKm(dto.getDistanciaKm());
        return ejercicio;
    }

    public Rutina crearRutina(RutinaDTO rutinaDTO){
        List<Ejercicio> ejercicios = rutinaDTO.getEjercicios()
                .stream()
                .map(this::mapearEjercicio)
                .collect(Collectors.toList());

        Rutina rutina = new Rutina();
        rutina.setNombreRutina(rutinaDTO.getNombreRutina());
        rutina.setDuracionApp(rutinaDTO.getDuracionApp());
        rutina.setEjercicios(ejercicios);

        return rutinaRepository.save(rutina);
    }

    // Listar todas las rutinas disponibles

    public List<Rutina> listarRutinas(){
        return rutinaRepository.findAll();
    }

    // Listar las rutinas por ID
    public Rutina listarPorId(Long idRutina){
        return rutinaRepository.findById(idRutina)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada con id: " + idRutina));
    }

    // Eliminar rutinas
    public void eliminarRutina(Long idRutina){
        if(!rutinaRepository.existsById(idRutina)){
            throw new RuntimeException("No existe ninguna rutina con ese ID");
        }

        rutinaRepository.deleteById(idRutina);
    }
}
