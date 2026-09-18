package com.biolab.plataformadecursos.services;

import com.biolab.plataformadecursos.DTOs.CursoDTO;
import com.biolab.plataformadecursos.entities.Curso;
import com.biolab.plataformadecursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String criarCurso(CursoDTO dto){
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso criado com sucesso";
    }

    public List<CursoDTO> mostrarCursos(){
        return cursoRepository.findAll().stream().map(curso -> new CursoDTO(curso.getId(), curso.getNome(), curso.getCargaHoraria())).toList();
    }

    public String deletarCurso(long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(id);
        return "Curso excluído com sucesso";
    }

    public String editarCurso(long id, CursoDTO dto){
        Curso editarCurso = cursoRepository.findById(id).orElseThrow();
        editarCurso.setNome(dto.getNome());
        editarCurso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(editarCurso);
        return "Informações editadas com sucesso";
    }

    public CursoDTO buscarCursoPorId(long id){
        Curso curso = new Curso();
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNome(cursoDTO.getNome());
        cursoDTO.setCargaHoraria(cursoDTO.getCargaHoraria());
        return cursoDTO;
    }
}
