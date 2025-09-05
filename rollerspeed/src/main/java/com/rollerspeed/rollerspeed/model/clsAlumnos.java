/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class clsAlumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(unique = true)
    private String documento;

    @Past
    private LocalDate fechaNacimiento;

    @Email
    private String email;

    private String telefono;

    private String nivel;

    private boolean activo = true;

    // Relación con pagos
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<clsPagos> pagos;

    // Relación con cursos
    @ManyToMany
    @JoinTable(
        name = "alumno_curso",
        joinColumns = @JoinColumn(name = "alumno_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<clsCursos> cursos;

    // Relación con notificaciones
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<clsNotificaciones> notificaciones;

    // --- Getters y Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public List<clsPagos> getPagos() { return pagos; }
    public void setPagos(List<clsPagos> pagos) { this.pagos = pagos; }

    public List<clsCursos> getCursos() { return cursos; }
    public void setCursos(List<clsCursos> cursos) { this.cursos = cursos; }

    public List<clsNotificaciones> getNotificaciones() { return notificaciones; }
    public void setNotificaciones(List<clsNotificaciones> notificaciones) { this.notificaciones = notificaciones; }
}
