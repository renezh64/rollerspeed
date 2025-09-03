/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.clsAspirantes;
import com.rollerspeed.rollerspeed.repository.clsAspitantesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class clsAspirantesController
{
   @Autowired
   private clsAspirantesRepository AspiranteRepository;
   
   @GetMapping("/")
   public String index()
   {
       return "index";
   }
   
   //Mision
   
   
}
