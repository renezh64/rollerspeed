/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.clsAspirantes;
import com.rollerspeed.rollerspeed.repository.clsAspitantesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class clsAspirantesController
{
   @Autowired
   private clsAspitantesRepository AspiranteRepository;
   
   @GetMapping("/")
   public String index()
   {
       return "index";
   }
   
   // Página de misión
    @GetMapping("/mision")
    public String mision() {
        return "mision";
    }

    // Página de registro
    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("Aspirante", new clsAspirantes());
        return "registrar";
    }

    // Guardar persona
    @PostMapping("/registrar")
    public String registrarAspirante(clsAspirantes aspirante) {
        AspiranteRepository.save(aspirante);
        return "redirect:/listar";
    }

    // Listar personas
    @GetMapping("/listar")
    public String listarAspirante(Model model) {
        model.addAttribute("Aspirante", AspiranteRepository.findAll());
        return "listar";
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        clsAspirantes aspirante = AspiranteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("Aspirante", aspirante);
        return "editar";
    }

    // Actualizar persona
    @PostMapping("/editar/{id}")
    public String actualizarAspirante(@PathVariable Long id, clsAspirantes aspirante) {
        aspirante.setId(id);
        AspiranteRepository.save(aspirante);
        return "redirect:/listar";
    }

    // Eliminar persona
    @GetMapping("/eliminar/{id}")
    public String eliminarAspirante(@PathVariable Long id) {
        AspiranteRepository.deleteById(id);
        return "redirect:/listar";
    }
   
   
}
