/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "clsClases")
public class Clase {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "IdInstructor", nullable = false)
    private Instructor instructor;

    @Column(name = "strNombre", nullable = false)
    private String nombre;

    @Column(name = "strDescripcion")
    private String descripcion;

    @Column(name = "strDia", nullable = false)
    private String dia;

    @Column(name = "strHoraIni", nullable = false)
    private LocalTime horaIni;

    @Column(name = "strHoraFin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "FechaIni", nullable = false)
    private LocalDate fechaIni;

    @Column(name = "FechaFin")
    private LocalDate fechaFin;

    // Getters y Setters
    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getDia() { return dia; }
    public void setDia(String dia) { this.dia = dia; }
    public LocalTime getHoraIni() { return horaIni; }
    public void setHoraIni(LocalTime horaIni) { this.horaIni = horaIni; }
    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
    public LocalDate getFechaIni() { return fechaIni; }
    public void setFechaIni(LocalDate fechaIni) { this.fechaIni = fechaIni; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; } 
}
