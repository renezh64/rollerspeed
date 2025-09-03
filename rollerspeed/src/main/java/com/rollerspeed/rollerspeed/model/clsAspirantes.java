/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/**
 *
 * @author Usuario
 */
@Entity
public class clsAspirantes 
{   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String strTipoID;
    private String strNumID;
    private String strNombres;
    private String strApellidos;
    private String strMedioPag;
    
    //Geters y Seters
    public Long getId() 
    { return this.Id;}
    
    public void setId(Long Id)
    {
        if(Id>0)
        { this.Id=Id; }        
    }
    
    public String getstrTipoId()
    {return this.strTipoID;}
    
    public void setstrTipoID(String TipoId)
    {//verificar la entrada?
        this.strTipoID= TipoId;
    }
    
    public String getstrNumID()
    {  return this.strNumID;  }
    
    public void setstrNumID(String strNumID)
    { this.strNumID=strNumID;  }
    
    public String getstrNombres()
    { return this.strNombres; }
    
    public void setstrNombres(String strNombres)
    { this.strNombres=strNombres;  }
    
    public String getstrApellidos()
    { return this.strApellidos; }
    
    public void setstrApellidos(String strApellidos)
    { this.strApellidos=strApellidos;  }
    
    /**
     * @return the strMedioPag
     */
    public String getStrMedioPag() {
        return strMedioPag;
    }

    /**
     * @param strMedioPag the strMedioPag to set
     */
    public void setStrMedioPag(String strMedioPag) {
        this.strMedioPag = strMedioPag;
    }
    
}
