package com.example.gestionestudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.gestionestudiantes.model.Estudiante;
import com.example.gestionestudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionEstudiantesApplication implements CommandLineRunner{

	 @Autowired
	    private EstudianteService estudianteService;

	    public static void main(String[] args) {
	        SpringApplication.run(GestionEstudiantesApplication.class, args);
	    }

	    @Override
	    public void run(String... args) throws Exception {
	        // Crear estudiantes por defecto
	        Estudiante estudiante1 = new Estudiante();
	        estudiante1.setNombreCompleto("Juan Pérez");
	        estudiante1.setEmail("juan.perez@example.com");
	        estudiante1.setEdad(20);
	        estudiante1.setProgramaAcademico("Ingeniería de Sistemas");
	        estudiante1.setAnioIngreso(2022);

	        Estudiante estudiante2 = new Estudiante();
	        estudiante2.setNombreCompleto("María Gómez");
	        estudiante2.setEmail("maria.gomez@example.com");
	        estudiante2.setEdad(22);
	        estudiante2.setProgramaAcademico("Administración de Empresas");
	        estudiante2.setAnioIngreso(2021);

	        Estudiante estudiante3 = new Estudiante();
	        estudiante3.setNombreCompleto("Carlos López");
	        estudiante3.setEmail("carlos.lopez@example.com");
	        estudiante3.setEdad(23);
	        estudiante3.setProgramaAcademico("Derecho");
	        estudiante3.setAnioIngreso(2020);

	        // Guardar estudiantes en la base de datos
	        estudianteService.crearEstudiante(estudiante1);
	        estudianteService.crearEstudiante(estudiante2);
	        estudianteService.crearEstudiante(estudiante3);
	    }
}
