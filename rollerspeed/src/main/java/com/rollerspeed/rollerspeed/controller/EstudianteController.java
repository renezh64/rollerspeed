/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Estudiante;
import com.rollerspeed.rollerspeed.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Rene Zapata
 */
@RestController
@RequestMapping("/estudiante")
public class EstudianteController 
{
    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "estudiante/listar";
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/estudiante/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("estudiante", estudiante);
        return "estudiante/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, Estudiante estudiante) {
        estudiante.setId(id);
        estudianteRepository.save(estudiante);
        return "redirect:/estudiante/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
        return "redirect:/estudiante/listar";
    }
}
