package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
/**
 *
 * @author Rene Zapata
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
     // Página de login
    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }
    
    // Mostrar datos del usuario autenticado
    @GetMapping("/perfil")
    public String perfil(Authentication authentication, Model model) {
        String username = authentication.getName();
        Usuario usuario = usuarioRepository.findByNombUsuario(username);
        model.addAttribute("usuario", usuario);
        return "usuario/perfil";
    }
    
    // Listar usuarios
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/listar";
    }
    
    // Registrar usuario
    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/registrar";
    }
    
    @PostMapping("/registrar")
    public String registrar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuario/registrar";
        }
        usuario.setStrClaveAcc(passwordEncoder.encode(usuario.getStrClaveAcc()));
        usuarioRepository.save(usuario);
        return "redirect:/usuario/listar";
    }
    
     // Editar usuario
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("usuario", usuario);
        return "usuario/editar";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuario/editar";
        }
        usuario.setId(id);
        if (!usuario.getStrClaveAcc().isEmpty()) {
            usuario.setStrClaveAcc(passwordEncoder.encode(usuario.getStrClaveAcc()));
        } else {
            // Mantener la contraseña existente si no se proporciona una nueva
            Usuario existing = usuarioRepository.findById(id).orElseThrow();
            usuario.setStrClaveAcc(existing.getStrClaveAcc());
        }
        usuarioRepository.save(usuario);
        return "redirect:/usuario/listar";
    }
    
    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuario/listar";
    }
}
