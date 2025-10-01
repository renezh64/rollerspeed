package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        // login.html está dentro de templates/usuario/
        return "usuario/login";
    }

    @GetMapping("/home")
    public String home() {
        return "index"; // templates/index.html
    }
     @GetMapping("/logout")
    public String logout() {
        return "/logout"; // templates/index.html
    }
}
    