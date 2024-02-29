package com.daenamorado.msvc.cursos.msvccursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.daenamorado.msvc.cursos.msvccursos.entity.Curso;
import com.daenamorado.msvc.cursos.msvccursos.repositories.CursoRepository;

public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> getAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> getById(Long Id) {
        return cursoRepository.findById(Id);
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void delete(Long Id) {
        cursoRepository.deleteById(Id);
    }

}
