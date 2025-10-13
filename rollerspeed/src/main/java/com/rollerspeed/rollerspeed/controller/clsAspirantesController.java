package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.clsAspirantes;
import com.rollerspeed.rollerspeed.repository.clsAspitantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/aspirantes")
@SessionAttributes({"usuario"})
public class clsAspirantesController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private clsAspitantesRepository aspiranteRepository;

    // Listar aspirantes
    @GetMapping
    public String listarAspirante(Authentication authentication, Model model) 
    {
        String username = authentication.getName();
        Usuario myUsr = usuarioRepository.findByNombUsuario(username);
        if(myUsr.getStrNivelAcc().compareTo("ADMIN")==0)
        {
            model.addAttribute("Aspirantes", aspiranteRepository.findAll());
            return "listar"; // listar.html
        }
        else
        {
           return "usuario/perfil"; // listar.html
        }
    }

    // Mostrar formulario de registro
    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("aspirante", new clsAspirantes()); // <-- Cambiado a minúscula
        return "registrar"; // registrar.html
    }

    // Guardar aspirante
    @PostMapping("/registrar")
    public String registrarAspirante(@ModelAttribute("aspirante") clsAspirantes aspirante) { // <-- minúscula
        aspiranteRepository.save(aspirante);
        return "redirect:/aspirantes";
    }

    // Editar aspirante
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        clsAspirantes aspirante = aspiranteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("aspirante", aspirante); // <-- Cambiado a minúscula
        return "editar"; // editar.html
    }

    @PostMapping("/editar/{id}")
    public String actualizarAspirante(@PathVariable Long id, clsAspirantes aspirante) {
        aspirante.setId(id);
        aspiranteRepository.save(aspirante);
        return "redirect:/aspirantes";
    }

    // Eliminar aspirante
    @GetMapping("/eliminar/{id}")
    public String eliminarAspirante(@PathVariable Long id) {
        aspiranteRepository.deleteById(id);
        return "redirect:/aspirantes";
    }

    // Misión
    @GetMapping("/mision")
    public String mision() {
        return "mision"; // mision.html
    }
}
