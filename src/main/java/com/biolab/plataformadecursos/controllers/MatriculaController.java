package com.biolab.plataformadecursos.controllers;

import com.biolab.plataformadecursos.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("matricula")
public class MatriculaController {
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<?> matricularAluno(@RequestParam long idAluno, @RequestParam long idCurso){
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.matricularAluno(idAluno, idCurso));
    }
}
