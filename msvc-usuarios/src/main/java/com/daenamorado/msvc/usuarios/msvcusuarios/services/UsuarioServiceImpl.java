package com.daenamorado.msvc.usuarios.msvcusuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daenamorado.msvc.usuarios.msvcusuarios.models.entity.usuario;
import com.daenamorado.msvc.usuarios.msvcusuarios.repositories.UsuarioRepoitory;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepoitory repoitory;

    @Override
    @Transactional(readOnly = true)
    public List<usuario> getAll() {
        return (List<usuario>) repoitory.findAll();
    }

    /**
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<usuario> getById(Long id) {
        return repoitory.findById(id);
    }

    @Override
    @Transactional
    public usuario guardar(usuario usuario) {
        return repoitory.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repoitory.deleteById(id);
    }

}
