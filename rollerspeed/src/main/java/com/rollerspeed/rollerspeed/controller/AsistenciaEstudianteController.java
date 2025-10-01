/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.AsistenciaEstudiante;
import com.rollerspeed.rollerspeed.repository.AsistenciaEstudianteRepository;
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
/**
 *
 * @author Rene Zapata
 */
@RestController
@RequestMapping("/asistencia")
public class AsistenciaEstudianteController 
{
   @Autowired
    private AsistenciaEstudianteRepository asistenciaEstudianteRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("asistencias", asistenciaEstudianteRepository.findAll());
        return "asistencia/listar";
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asistencia", new AsistenciaEstudiante());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("clases", claseRepository.findAll());
        return "asistencia/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(AsistenciaEstudiante asistencia) {
        asistenciaEstudianteRepository.save(asistencia);
        return "redirect:/asistencia/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        AsistenciaEstudiante asistencia = asistenciaEstudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("asistencia", asistencia);
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("clases", claseRepository.findAll());
        return "asistencia/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, AsistenciaEstudiante asistencia) {
        asistencia.setId(id);
        asistenciaEstudianteRepository.save(asistencia);
        return "redirect:/asistencia/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        asistenciaEstudianteRepository.deleteById(id);
        return "redirect:/asistencia/listar";
    } 
}
