package com.rollerspeed.rollerspeed.model;
import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "clsAsistenciaEstudiante")
public class AsistenciaEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "IdEstudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "IdClase", nullable = false)
    private Clase clase;

    @Column(name = "dFechaAsis", nullable = false)
    private LocalDate fechaAsis;

    @Column(name = "strAsistio", nullable = false)
    private String asistio;

    // Getters y Setters
    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }
    public LocalDate getFechaAsis() { return fechaAsis; }
    public void setFechaAsis(LocalDate fechaAsis) { this.fechaAsis = fechaAsis; }
    public String getAsistio() { return asistio; }
    public void setAsistio(String asistio) { this.asistio = asistio; }
}
