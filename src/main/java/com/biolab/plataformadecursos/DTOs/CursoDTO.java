package com.biolab.plataformadecursos.DTOs;


import com.biolab.plataformadecursos.entities.Curso;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    private int cargaHoraria;

    public CursoDTO(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.cargaHoraria = curso.getCargaHoraria();
    }
}
