package com.rutinas.rutinas.controller;

import com.rutinas.rutinas.dto.RutinaDTO;
import com.rutinas.rutinas.model.Rutina;
import com.rutinas.rutinas.repository.RutinaRepository;
import com.rutinas.rutinas.service.RutinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gym/rutinas")
@RequiredArgsConstructor
public class RutinaController {

    private final RutinaService rutinaService;
    private final RutinaRepository rutinaRepository;

    // Listar rutinas
    @GetMapping("/listarRutinas")
    public ResponseEntity<List<Rutina>> obtenerRutinas(){
        return ResponseEntity.ok(rutinaService.listarRutinas());
    }

    @GetMapping("/listarRutinas/id/{idRutina}")
    public ResponseEntity<Rutina> obtenerRutinaID(@PathVariable Long idRutina){
        return ResponseEntity.ok(rutinaService.listarPorId(idRutina));
    }

    @PostMapping("/crearRutina")
    public ResponseEntity<?> crearRutina(@RequestBody RutinaDTO rutinaDTO){
        Rutina rutinaguardada = rutinaService.crearRutina(rutinaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(rutinaguardada);
    }

    @DeleteMapping("/borrarRutina/{idRutina}")
    public ResponseEntity<?> eliminarRutina(@PathVariable Long idRutina) {
        rutinaService.eliminarRutina(idRutina);
        return ResponseEntity.ok("Rutina eliminada correctamente");
    }
}
