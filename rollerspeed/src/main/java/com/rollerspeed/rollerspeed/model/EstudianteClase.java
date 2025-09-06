/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;
import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "clsEstudianteClase")
public class EstudianteClase {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "IdEstudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "IdClase", nullable = false)
    private Clase clase;

    @Column(name = "dFechaCre", nullable = false)
    private LocalDate fechaCre;

    // Getters y Setters
    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }
    public LocalDate getFechaCre() { return fechaCre; }
    public void setFechaCre(LocalDate fechaCre) { this.fechaCre = fechaCre; }
}
