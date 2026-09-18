package com.biolab.plataformadecursos.controllers;

import com.biolab.plataformadecursos.DTOs.AlunoDTO;
import com.biolab.plataformadecursos.entities.Aluno;
import com.biolab.plataformadecursos.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<?> saveAluno (@RequestBody AlunoDTO dto){
        return ResponseEntity.ok(alunoService.criarAluno(dto));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> mostrarAlunos(){
        return ResponseEntity.ok(alunoService.mostrarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAluno(@PathVariable long id){
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAluno(@PathVariable Long id, @RequestBody AlunoDTO dto){
        return ResponseEntity.ok(alunoService.editarAluno(id, dto));
    }
}
