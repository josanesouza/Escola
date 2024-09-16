package com.souza.escola.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "nota_primeiro_semestre", precision = 5, scale = 2, nullable = false)
    private BigDecimal notaPrimeiroSemestre;

    @Column(name = "nota_segundo_semestre", precision = 5, scale = 2, nullable = false)
    private BigDecimal notaSegundoSemestre;

    @Column(name = "nome_professor", length = 100, nullable = false)
    private String nomeProfessor;

    @Column(name = "numero_sala", nullable = false)
    private Integer numeroSala;

    // Construtor com parâmetros
    @Builder
    public Aluno(String nome, Integer idade, BigDecimal notaPrimeiroSemestre, BigDecimal notaSegundoSemestre, String nomeProfessor, Integer numeroSala) {
        this.nome = nome;
        this.idade = idade;
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
        this.notaSegundoSemestre = notaSegundoSemestre;
        this.nomeProfessor = nomeProfessor;
        this.numeroSala = numeroSala;
    }

}
