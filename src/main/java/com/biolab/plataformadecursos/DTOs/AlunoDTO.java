package com.biolab.plataformadecursos.DTOs;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    private Set<CursoDTO> cursos = new HashSet<>();

    public AlunoDTO(String nome, String email, Set<CursoDTO> cursos) {
        this.nome = nome;
        this.email = email;
        this.cursos = cursos;
    }

    public AlunoDTO(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
