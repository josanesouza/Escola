package com.souza.escola.dto.request;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class AlunoRequestDTO {

	private String nome;

	private Integer idade;

	private BigDecimal notaPrimeiroSemestre;

	private BigDecimal notaSegundoSemestre;

	private String nomeProfessor;

	private Integer numeroSala;

}
