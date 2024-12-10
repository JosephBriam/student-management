package com.example.gestionestudiantes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.Year;

@Entity
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre completo es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombreCompleto;

    @NotNull(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    private String email;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "La edad mínima es 18 años")
    @Max(value = 65, message = "La edad máxima es 65 años")
    private Integer edad;

    @NotNull(message = "El programa académico es obligatorio")
    private String programaAcademico;

    @NotNull(message = "El año de ingreso es obligatorio")
    @Min(value = 2000, message = "El año de ingreso mínimo es 2000")
    private Integer anioIngreso;

    @AssertTrue(message = "El año de ingreso no puede ser mayor que el año actual")
    public boolean isAnioIngresoValido() {
        return anioIngreso <= Year.now().getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Integer anioIngreso) {
        this.anioIngreso = anioIngreso;
    }
}
