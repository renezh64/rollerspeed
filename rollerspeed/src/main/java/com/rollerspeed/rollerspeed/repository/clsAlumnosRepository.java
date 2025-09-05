/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rollerspeed.rollerspeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rollerspeed.rollerspeed.model.clsAlumnos;

public interface clsAlumnosRepository extends JpaRepository<clsAlumnos, Long> {
    boolean existsByDocumento(String documento);
}
