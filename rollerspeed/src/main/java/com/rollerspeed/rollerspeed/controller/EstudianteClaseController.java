/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.EstudianteClase;
import com.rollerspeed.rollerspeed.repository.EstudianteClaseRepository;
import com.rollerspeed.rollerspeed.repository.EstudianteRepository;
import com.rollerspeed.rollerspeed.repository.ClaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 *
 * @author Rene Zapata
 */
@Controller
@RequestMapping("/estudiante_clase")
@SessionAttributes({"usuario"})
public class EstudianteClaseController 
{
     @Autowired
    private EstudianteClaseRepository estudianteClaseRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("estudianteClases", estudianteClaseRepository.findAll());
        return "estudiante_clase/listar";
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudianteClase", new EstudianteClase());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("clases", claseRepository.findAll());
        return "estudiante_clase/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(EstudianteClase estudianteClase) {
        estudianteClaseRepository.save(estudianteClase);
        return "redirect:/estudiante_clase/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        EstudianteClase estudianteClase = estudianteClaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("estudianteClase", estudianteClase);
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("clases", claseRepository.findAll());
        return "estudiante_clase/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, EstudianteClase estudianteClase) {
        estudianteClase.setId(id);
        estudianteClaseRepository.save(estudianteClase);
        return "redirect:/estudiante_clase/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudianteClaseRepository.deleteById(id);
        return "redirect:/estudiante_clase/listar";
    }
}
