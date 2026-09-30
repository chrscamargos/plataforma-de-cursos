package com.biolab.plataformadecursos.services;

import com.biolab.plataformadecursos.entities.Aluno;
import com.biolab.plataformadecursos.entities.Curso;
import com.biolab.plataformadecursos.repositories.AlunoRepository;
import com.biolab.plataformadecursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String matricularAluno(long idAluno, long idCurso){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        Curso curso = cursoRepository.findById(idCurso).orElseThrow();
        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);
        return "aluno matriculado com sucesso";
    }
}
