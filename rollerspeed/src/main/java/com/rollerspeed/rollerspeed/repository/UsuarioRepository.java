/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rollerspeed.rollerspeed.repository;

import com.rollerspeed.rollerspeed.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rene Zapata 
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombUsuario(String nombUsuario); //se usara para autentificar el usario por el nombre
    
}
