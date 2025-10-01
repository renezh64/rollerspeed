/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.config;

import com.rollerspeed.rollerspeed.repository.UsuarioRepository;
import com.rollerspeed.rollerspeed.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.SessionRepositoryFilter;
/**
 *
 * @author Rene Zapata Hernandez
 */
 @Configuration
 @EnableJdbcHttpSession //habilita sesiion don jdbc
public class SessionConfig 
{
     @Autowired
    private UsuarioRepository usuarioRepository;
    
}
