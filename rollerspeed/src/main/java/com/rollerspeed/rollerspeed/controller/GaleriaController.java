package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"usuario"})
public class GaleriaController {

    @GetMapping("/galeria")
    public String mostrarGaleria(Model model) {
        List<String> imagenes = Arrays.asList(
                "foto1.png",
                "foto2.png",
                "foto3.png",
                "foto4.png",
                "foto5.png"
        );
        model.addAttribute("imagenes", imagenes);
        return "galeria"; // busca galeria.html en templates
    }
}