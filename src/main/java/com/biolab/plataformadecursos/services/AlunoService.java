package com.biolab.plataformadecursos.services;

import com.biolab.plataformadecursos.DTOs.AlunoDTO;
import com.biolab.plataformadecursos.DTOs.CursoDTO;
import com.biolab.plataformadecursos.entities.Aluno;
import com.biolab.plataformadecursos.entities.Curso;
import com.biolab.plataformadecursos.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public String criarAluno(AlunoDTO dto){
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        alunoRepository.save(aluno);
        return "Aluno adicionado com sucesso";
    }

    public List<AlunoDTO> mostrarAlunos(){
        return alunoRepository.findAll().stream().map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail())).toList();
    }

    public String editarAluno(long id, AlunoDTO dto){
        Aluno editarAluno = alunoRepository.findById(id).orElseThrow();
        editarAluno.setEmail(dto.getEmail());
        alunoRepository.save(editarAluno);
        return "Informações editadas com sucesso";
    }

    public String deletarAluno(long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        alunoRepository.deleteById(id);
        return "Aluno excluído com sucesso";
    }

    public AlunoDTO buscarAlunoPorId (long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setId(aluno.getId());
        for (Curso curso : aluno.getCursos()){
            CursoDTO cursoDTO = new CursoDTO(curso);
            alunoDTO.getCursos().add(cursoDTO);
        }
        return alunoDTO;
    }
}
