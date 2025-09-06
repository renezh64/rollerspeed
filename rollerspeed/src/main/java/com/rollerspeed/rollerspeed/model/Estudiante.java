package com.rollerspeed.rollerspeed.model;
import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author Usuario
 */
public class Estudiante {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "strTipoID", nullable = false)
    private String tipoID;

    @Column(name = "strNumID", nullable = false)
    private String numID;

    @Column(name = "strNombres", nullable = false)
    private String nombres;

    @Column(name = "strApellidos", nullable = false)
    private String apellidos;

    @Column(name = "FechaNac", nullable = false)
    private LocalDate fechaNac;

    // Getters y Setters
    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }
    public String getTipoID() { return tipoID; }
    public void setTipoID(String tipoID) { this.tipoID = tipoID; }
    public String getNumID() { return numID; }
    public void setNumID(String numID) { this.numID = numID; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public LocalDate getFechaNac() { return fechaNac; }
    public void setFechaNac(LocalDate fechaNac) { this.fechaNac = fechaNac; }
    
}
