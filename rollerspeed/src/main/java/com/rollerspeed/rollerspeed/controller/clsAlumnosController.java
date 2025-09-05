/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.clsAlumnos;
import com.rollerspeed.rollerspeed.repository.clsAlumnosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class clsAlumnosController {

    @Autowired
    private clsAlumnosRepository alumnosRepository;

    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnosRepository.findAll());
        return "alumnos/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("alumno", new clsAlumnos());
        return "alumnos/registrar";
    }

    @PostMapping
    public String registrarAlumno(@Valid @ModelAttribute("alumno") clsAlumnos alumno,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "alumnos/registrar";
        }
        if (alumnosRepository.existsByDocumento(alumno.getDocumento())) {
            result.rejectValue("documento", "error.alumno", "Documento ya registrado");
            return "alumnos/registrar";
        }
        alumnosRepository.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        clsAlumnos alumno = alumnosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("alumno", alumno);
        return "alumnos/editar";
    }

    @PostMapping("/{id}/editar")
    public String actualizarAlumno(@PathVariable Long id,
                                   @Valid @ModelAttribute("alumno") clsAlumnos alumno,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "alumnos/editar";
        }
        alumno.setId(id);
        alumnosRepository.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/{id}/pagos")
    public String verPagos(@PathVariable Long id, Model model) {
        clsAlumnos alumno = alumnosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("alumno", alumno);
        model.addAttribute("pagos", alumno.getPagos());
        return "alumnos/pagos";
    }

    @GetMapping("/{id}/horarios")
    public String verHorarios(@PathVariable Long id, Model model) {
        clsAlumnos alumno = alumnosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", alumno.getCursos());
        return "alumnos/horarios";
    }

    @GetMapping("/{id}/notificaciones")
    public String verNotificaciones(@PathVariable Long id, Model model) {
        clsAlumnos alumno = alumnosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("alumno", alumno);
        model.addAttribute("notificaciones", alumno.getNotificaciones());
        return "alumnos/notificaciones";
    }
}
