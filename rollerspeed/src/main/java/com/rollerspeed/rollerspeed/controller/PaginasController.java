package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {

    @GetMapping("/mision")
    public String mision() {
        return "mision"; // Busca src/main/resources/templates/mision.html
    }

    @GetMapping("/vision")
    public String vision() {
        return "mision#Vision"; // Salto a sección
    }

    @GetMapping("/valores")
    public String valores() {
        return "mision#ValoresCorporativos"; // Salto a sección
    }
}
