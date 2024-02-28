package com.daenamorado.msvc.usuarios.msvcusuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.daenamorado.msvc.usuarios.msvcusuarios.models.entity.usuario;
import com.daenamorado.msvc.usuarios.msvcusuarios.services.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController()
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping    
    public List<usuario> getAll() {
        return  service.getAll();
    }


    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { 
        Optional<usuario> optionalUsuario = service.getById(id);
        return (optionalUsuario.isPresent()) ? ResponseEntity.ok(optionalUsuario.get()) : ResponseEntity.notFound().build();
    }

    /**
     * @param usuario
     * @return
     */
    @PostMapping
    public ResponseEntity<usuario> create(@RequestBody usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody usuario usuario, @PathVariable Long id) {
        Optional<usuario> o = service.getById(id);

        if(o.isPresent()) {
            usuario usuarioDb = o.get();
            usuarioDb.setName(usuario.getName());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioDb));
        }

        return ResponseEntity.notFound().build();   
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<usuario> o = service.getById(id);
        if (o.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
