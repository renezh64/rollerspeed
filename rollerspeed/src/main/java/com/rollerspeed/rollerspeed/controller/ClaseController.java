package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Clase;
import com.rollerspeed.rollerspeed.model.Estudiante;
import com.rollerspeed.rollerspeed.repository.ClaseRepository;
import com.rollerspeed.rollerspeed.repository.InstructorRepository;
import com.rollerspeed.rollerspeed.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clase")
public class ClaseController {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private EstudianteRepository estudianteRepository; // <-- agregado

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("clases", claseRepository.findAll());
        return "clase/listar";
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("clase", new Clase());
        model.addAttribute("instructores", instructorRepository.findAll());
        model.addAttribute("estudiantes", estudianteRepository.findAll()); // <-- agregado
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
        model.addAttribute("estudiantes", estudianteRepository.findAll()); // <-- agregado
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
