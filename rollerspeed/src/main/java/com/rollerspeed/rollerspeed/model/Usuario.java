package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.*;
import jakarta.validation.constrains.NotBlank;


/**
 *
 * @author Rene Zapata
 */
@Entity
@Table(name= "tblUsarios")
public class Usuario 
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Id;
    
    @NotBlank(message="Por favor ingresar nombre")
    @Column(name="Nombres",nullable=false)
    private String strNombres;
    
    @NotBlank(message="Por favor ingresar Apellidos")
    @Column(name="Apellidos",nullable=false)
    private String strApellidos;
    
    @NotBlank(message="Por favor ingresar Nombre de usario")
    @Column(name="NomUsario", nullable = false, unique =true)
    private String strApellidos;
    
    @NotBlank(message="Por favor la clave por favor")
    @Column(name="ClaveAcc", nullable=false )
    private String strClaveAcc;
    
    @NotBlank(message="Por favor Nivel de Acceso")
    @Column(name="NivelAcc",nullable=false)
    private String strNivelAcc;
    
    @NotBlank(message="Por favor ingresar si esta activo inactivo")
    @Column(name="Activo",nullable=false)
    private String strActivo;
    
    @Column(name="Notas")
    private String strNotas;

    /**
     * @return the Id
     */
    public Long getId()
    { return Id; }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id)
    { this.Id = Id; }

    /**
     * @return the strNombres
     */
    public String getStrNombres() 
    { return strNombres; }

    /**
     * @param strNombres the strNombres to set
     */
    public void setStrNombres(String strNombres) 
    { this.strNombres = strNombres; }

    /**
     * @return the strApellidos
     */
    public String getStrApellidos() 
    { return strApellidos; }

    /**
     * @param strApellidos the strApellidos to set
     */
    public void setStrApellidos(String strApellidos) 
    { this.strApellidos = strApellidos;  }

    /**
     * @return the strApellidos
     */
    public String getStrApellidos() 
    { return strApellidos; }

    /**
     * @param strApellidos the strApellidos to set
     */
    public void setStrApellidos(String strApellidos) 
    { this.strApellidos = strApellidos; }

    /**
     * @return the strClaveAcc
     */
    public String getStrClaveAcc() 
    { return strClaveAcc;  }

    /**
     * @param strClaveAcc the strClaveAcc to set
     */
    public void setStrClaveAcc(String strClaveAcc) 
    { this.strClaveAcc = strClaveAcc; }

    /**
     * @return the strNivelAcc
     */
    public String getStrNivelAcc() 
    { return strNivelAcc; }

    /**
     * @param strNivelAcc the strNivelAcc to set
     */
    public void setStrNivelAcc(String strNivelAcc) 
    { this.strNivelAcc = strNivelAcc; }

    /**
     * @return the strActivo
     */
    public String getStrActivo() 
    { return strActivo; }

    /**
     * @param strActivo the strActivo to set
     */
    public void setStrActivo(String strActivo) 
    { this.strActivo = strActivo; }

    /**
     * @return the strNotas
     */
    public String getStrNotas()
    { return strNotas; }

    /**
     * @param strNotas the strNotas to set
     */
    public void setStrNotas(String strNotas) 
    { this.strNotas = strNotas; }
    
}
