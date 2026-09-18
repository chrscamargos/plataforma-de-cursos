package com.biolab.plataformadecursos.controllers;
import com.biolab.plataformadecursos.DTOs.CursoDTO;
import com.biolab.plataformadecursos.services.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> saveCurso (@RequestBody CursoDTO dto){
        return ResponseEntity.ok(cursoService.criarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> mostrarCursos(){
        return ResponseEntity.ok(cursoService.mostrarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCurso(@PathVariable long id){
        return ResponseEntity.ok(cursoService.buscarCursoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable long id){
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarCurso(@PathVariable Long id, @RequestBody CursoDTO dto){
        return ResponseEntity.ok(cursoService.editarCurso(id, dto));
    }
}
