package com.daenamorado.msvc.cursos.msvccursos.services;

import java.util.List;
import java.util.Optional;

import com.daenamorado.msvc.cursos.msvccursos.entity.Curso;

public interface CursoService {
    List<Curso> getAll();
    Optional<Curso> getById(Long Id);
    Curso guardar(Curso curso);
    void delete(Long Id);
}
