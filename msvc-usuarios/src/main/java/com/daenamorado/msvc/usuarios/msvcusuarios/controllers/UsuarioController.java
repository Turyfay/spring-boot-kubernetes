package com.daenamorado.msvc.usuarios.msvcusuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.daenamorado.msvc.usuarios.msvcusuarios.models.entity.usuario;
import com.daenamorado.msvc.usuarios.msvcusuarios.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping    
    public List<usuario> getAll() {
        return  service.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { 
        Optional<usuario> optionalUsuario = service.getById(id);
        return (optionalUsuario.isPresent()) ? ResponseEntity.ok(optionalUsuario.get()) : ResponseEntity.notFound().build();
    }

}
