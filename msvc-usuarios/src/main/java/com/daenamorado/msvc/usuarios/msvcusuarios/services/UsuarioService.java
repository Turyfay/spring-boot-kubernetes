package com.daenamorado.msvc.usuarios.msvcusuarios.services;

import java.util.List;
import java.util.Optional;

import com.daenamorado.msvc.usuarios.msvcusuarios.models.entity.usuario;

public interface UsuarioService {
    List<usuario> getAll();
    Optional<usuario> getById(Long id);
    usuario guardar(usuario usuario);
    void delete(Long id);
}
