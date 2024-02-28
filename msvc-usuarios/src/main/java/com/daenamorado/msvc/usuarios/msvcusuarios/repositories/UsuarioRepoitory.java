package com.daenamorado.msvc.usuarios.msvcusuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import com.daenamorado.msvc.usuarios.msvcusuarios.models.entity.usuario;

public interface UsuarioRepoitory extends CrudRepository<usuario, Long> {

}
