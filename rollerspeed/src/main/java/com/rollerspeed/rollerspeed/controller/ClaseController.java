/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Clase;
import com.rollerspeed.rollerspeed.repository.ClaseRepository;
import com.rollerspeed.rollerspeed.repository.InstructorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Rene Zapata
 */
@Controller
@RequestMapping("/clase")
public class ClaseController 
{
    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("clases", claseRepository.findAll());
        return "clase/listar";
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("clase", new Clase());
        model.addAttribute("instructores", instructorRepository.findAll());
        return "clase/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(Clase clase) {
        claseRepository.save(clase);
        return "redirect:/clase/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("clase", clase);
        model.addAttribute("instructores", instructorRepository.findAll());
        return "clase/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, Clase clase) {
        clase.setId(id);
        claseRepository.save(clase);
        return "redirect:/clase/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        claseRepository.deleteById(id);
        return "redirect:/clase/listar";
    }
}
