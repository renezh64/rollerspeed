/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author Rene Zapata
 * tabla o calse base instructores
 */
@Entity
@Table(name = "clsInstructores")//aqui es donde declaroel nombre de la tabla mas la doc indica que es relacinada con nombre de clase
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name= "strNombres", nullable=false)
    private String nombres;
    
    @Column(name = "strApellidos", nullable = false)
    private String apellidos;

    @Column(name = "strCorreo", nullable = false)
    private String correo;

    @Column(name = "dFechaEntra", nullable = false)
    private LocalDate fechaEntra;

    @Column(name = "dFechaSal")
    private LocalDate fechaSal;

    // Getters y Setters
    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }
   
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
   
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public LocalDate getFechaEntra() { return fechaEntra; }
    public void setFechaEntra(LocalDate fechaEntra) { this.fechaEntra = fechaEntra; }
    
    public LocalDate getFechaSal() { return fechaSal; }
    public void setFechaSal(LocalDate fechaSal) { this.fechaSal = fechaSal; }
}
