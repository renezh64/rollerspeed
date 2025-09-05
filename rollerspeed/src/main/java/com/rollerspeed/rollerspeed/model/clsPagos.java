/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;

@Entity
public class clsPagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private clsAlumnos alumno;

    // Constructor por defecto (requerido por JPA)
    public clsPagos() {}

    // Constructor con parámetros (útil para pruebas)
    public clsPagos(String descripcion, Double monto, clsAlumnos alumno) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.alumno = alumno;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }

    public clsAlumnos getAlumno() { return alumno; }
    public void setAlumno(clsAlumnos alumno) { this.alumno = alumno; }
}
