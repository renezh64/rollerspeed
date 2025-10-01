package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "tblUsuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message="Por favor ingresar nombre")
    @Column(name="Nombres", nullable=false)
    private String strNombres;

    @NotBlank(message="Por favor ingresar Apellidos")
    @Column(name="Apellidos", nullable=false)
    private String strApellidos;

    @NotBlank(message="Por favor ingresar Nombre de usuario")
    @Column(name="NomUsario", nullable=false, unique=true)
    private String nombUsuario;

    @NotBlank(message="Por favor la clave")
    @Column(name="ClaveAcc", nullable=false)
    private String strClaveAcc;

    @NotBlank(message="Por favor Nivel de Acceso")
    @Column(name="NivelAcc", nullable=false)
    private String strNivelAcc;

    @NotBlank(message="Por favor ingresar si esta activo o inactivo")
    @Column(name="Activo", nullable=false)
    private String strActivo;

    @Column(name="Notas")
    private String strNotas;

    // Getters y Setters
    public Long getId() { return Id; }
    public void setId(Long Id) { this.Id = Id; }

    public String getStrNombres() { return strNombres; }
    public void setStrNombres(String strNombres) { this.strNombres = strNombres; }

    public String getStrApellidos() { return strApellidos; }
    public void setStrApellidos(String strApellidos) { this.strApellidos = strApellidos; }

    public String getStrNomUsuario() { return nombUsuario; }
    public void setStrNomUsuario(String strNomUsuario) { this.nombUsuario = strNomUsuario; }

    public String getStrClaveAcc() { return strClaveAcc; }
    public void setStrClaveAcc(String strClaveAcc) { this.strClaveAcc = strClaveAcc; }

    public String getStrNivelAcc() { return strNivelAcc; }
    public void setStrNivelAcc(String strNivelAcc) { this.strNivelAcc = strNivelAcc; }

    public String getStrActivo() { return strActivo; }
    public void setStrActivo(String strActivo) { this.strActivo = strActivo; }

    public String getStrNotas() { return strNotas; }
    public void setStrNotas(String strNotas) { this.strNotas = strNotas; }
}
