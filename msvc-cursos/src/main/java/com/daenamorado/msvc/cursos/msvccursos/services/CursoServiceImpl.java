package com.daenamorado.msvc.cursos.msvccursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.daenamorado.msvc.cursos.msvccursos.entity.Curso;
import com.daenamorado.msvc.cursos.msvccursos.repositories.CursoRepository;

public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> getById(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Curso guardar(Curso curso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void delete(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
