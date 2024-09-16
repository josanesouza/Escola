package com.souza.escola.response;

import java.math.BigDecimal;

import com.souza.escola.entity.Aluno;

import lombok.Getter;

@Getter
public class AlunoResponseDTO {

	private Long id;

	private String nome;

	private Integer idade;

	private BigDecimal notaPrimeiroSemestre;

	private BigDecimal notaSegundoSemestre;

	private String nomeProfessor;

	private Integer numeroSala;

	public AlunoResponseDTO(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.idade = aluno.getIdade();
		this.notaPrimeiroSemestre = aluno.getNotaPrimeiroSemestre();
		this.notaSegundoSemestre = aluno.getNotaSegundoSemestre();
		this.nomeProfessor = aluno.getNomeProfessor();
		this.numeroSala = aluno.getNumeroSala();
	}

}
