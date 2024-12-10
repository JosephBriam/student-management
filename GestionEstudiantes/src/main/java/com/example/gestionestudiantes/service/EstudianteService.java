package com.example.gestionestudiantes.service;

import com.example.gestionestudiantes.model.Estudiante;
import com.example.gestionestudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public List<Estudiante> listarEstudiantes() {
        return repository.findAll();
    }

    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return repository.findById(id);
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        if (repository.existsById(id)) {
            estudiante.setId(id);
            return repository.save(estudiante);
        } else {
            throw new RuntimeException("Estudiante no encontrado");
        }
    }

    public void eliminarEstudiante(Long id) {
        repository.deleteById(id);
    }
}

