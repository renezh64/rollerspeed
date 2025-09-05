/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class clsCursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String horario;

    @ManyToMany(mappedBy = "cursos")
    private List<clsAlumnos> alumnos;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public List<clsAlumnos> getAlumnos() { return alumnos; }
    public void setAlumnos(List<clsAlumnos> alumnos) { this.alumnos = alumnos; }
}
