package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
@SessionAttributes({"usuario"})  //para asegurar que los datos del usario queden en la session y puedan ser leido desde otros controladores
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Mostrar formulario de registro
    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/registrar";
    }

    // Guardar usuario
    @PostMapping("/registrar")
    public String registrar(@Valid Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "usuario/registrar";
        }

        // Validar si ya existe el nombre de usuario
        if (usuarioRepository.findByNombUsuario(usuario.getStrNomUsuario()) != null) {
            result.rejectValue("strNomUsuario", "error.usuario", "El nombre de usuario ya está registrado");
            return "usuario/registrar";
        }

        usuario.setStrClaveAcc(passwordEncoder.encode(usuario.getStrClaveAcc()));
        usuarioRepository.save(usuario);

        return "redirect:/usuario/listar";
    }

    // Listar usuarios
    @GetMapping("/listar")
    public String listar(Authentication authentication, Model model) {        
        String username = authentication.getName();
        Usuario myUsr = usuarioRepository.findByNombUsuario(username);
        if(myUsr.getStrNivelAcc().compareTo("ADMIN")==0)
        {
            model.addAttribute("usuarios", usuarioRepository.findAll());
            return "usuario/listar";    
        }
        else
        {
            return "usuario/perfil";
        }    
    }

    // Perfil del usuario autenticado
    @GetMapping("/perfil")
    public String perfil(Authentication authentication, Model model) {
        String strUsrName = authentication.getName();
        Usuario usuario = usuarioRepository.findByNombUsuario(strUsrName);
        model.addAttribute("usuario", usuario);
        return "usuario/perfil";
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
