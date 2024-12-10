package com.example.gestionestudiantes.controller;

import com.example.gestionestudiantes.model.Estudiante;
import com.example.gestionestudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/estudiantes")
@Validated
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping

    public ResponseEntity<Estudiante> crearEstudiante(@Valid @RequestBody Estudiante estudiante, BindingResult result) {

      if (result.hasErrors()) {
        return ResponseEntity.badRequest().body(null);
      }
      Estudiante nuevoEstudiante = service.crearEstudiante(estudiante);
      return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return service.listarEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        return service.obtenerEstudiantePorId(id)
                .map(estudiante -> new ResponseEntity<>(estudiante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteActualizado = service.actualizarEstudiante(id, estudiante);
            return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        service.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
