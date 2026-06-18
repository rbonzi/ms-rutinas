package com.rutinas.rutinas.controller;

import com.rutinas.rutinas.dto.RutinaDTO;
import com.rutinas.rutinas.model.Rutina;
import com.rutinas.rutinas.repository.RutinaRepository;
import com.rutinas.rutinas.service.RutinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Listar rutinas", description = "Listar todas las rutinas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rutinas listadas correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<Rutina>> obtenerRutinas(){
        return ResponseEntity.ok(rutinaService.listarRutinas());
    }

    @GetMapping("/listarRutinas/id/{idRutina}")
    @Operation(summary = "Buscar rutina", description = "Busqueda de rutinas por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rutina encontrada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos invalidos"),
            @ApiResponse(responseCode = "404", description = "Rutina no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Rutina> obtenerRutinaID(@PathVariable Long idRutina){
        return ResponseEntity.ok(rutinaService.listarPorId(idRutina));
    }

    @PostMapping("/crearRutina")
    @Operation(summary = "Añadir rutina", description = "Añadir rutina")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rutina añadida correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos invalidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<?> crearRutina(@RequestBody RutinaDTO rutinaDTO){
        Rutina rutinaguardada = rutinaService.crearRutina(rutinaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(rutinaguardada);
    }

    @DeleteMapping("/borrarRutina/{idRutina}")
    @Operation(summary = "Eliminar rutinas", description = "Eliminar rutinas por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rutina eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos invalidos"),
            @ApiResponse(responseCode = "404", description = "Rutina no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<?> eliminarRutina(@PathVariable Long idRutina) {
        rutinaService.eliminarRutina(idRutina);
        return ResponseEntity.ok("Rutina eliminada correctamente");
    }
}
