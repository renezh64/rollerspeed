/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class clsNotificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private clsAlumnos alumno;

    // Constructor por defecto
    public clsNotificaciones() {}

    // Constructor con parámetros
    public clsNotificaciones(String mensaje, clsAlumnos alumno) {
        this.mensaje = mensaje;
        this.alumno = alumno;
    }

    // Método que asegura asignar la fecha al crear
    @PrePersist
    protected void onCreate() {
        if (fecha == null) {
            fecha = LocalDateTime.now();
        }
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public clsAlumnos getAlumno() { return alumno; }
    public void setAlumno(clsAlumnos alumno) { this.alumno = alumno; }
}
