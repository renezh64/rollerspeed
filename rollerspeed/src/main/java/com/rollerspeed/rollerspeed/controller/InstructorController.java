/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.InstructorRepository;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
        
/**
 * Controlador de instructor
 * @author Rene Zapata
 */
@Controller
@SessionAttributes({"usuario"})
@RequestMapping("/instructor")
public class InstructorController 
{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
     @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/listar")
    public String listar(Authentication authentication, Model model) {
        String username = authentication.getName();
        Usuario myUsr = usuarioRepository.findByNombUsuario(username);
        if(myUsr.getStrNivelAcc().compareTo("ADMIN")==0)
        {
             model.addAttribute("instructores", instructorRepository.findAll());
            return "instructor/listar";
        }
        else
        {
           return "usuario/perfil"; // listar.html
        }
        
       
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(Instructor instructor) {
        instructorRepository.save(instructor);
        return "redirect:/instructor/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("instructor", instructor);
        return "instructor/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, Instructor instructor) {
        instructor.setId(id);
        instructorRepository.save(instructor);
        return "redirect:/instructor/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        instructorRepository.deleteById(id);
        return "redirect:/instructor/listar";
    }
}
