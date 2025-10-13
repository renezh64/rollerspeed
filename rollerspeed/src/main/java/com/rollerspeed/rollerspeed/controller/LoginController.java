package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

@Controller
@SessionAttributes({"usuario"})
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login() {
        // login.html está dentro de templates/usuario/
        return "usuario/login";
    }

    @GetMapping("/home")
    public String home() {        
        return "index"; // templates/index.html
    }
    
    /*ya esta en el security*/
    @GetMapping("/logout")
    public String logout() {
        return "/logout"; // templates/index.html
    }
}
    