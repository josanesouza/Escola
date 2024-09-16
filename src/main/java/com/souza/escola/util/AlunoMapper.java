package com.souza.escola.util;

import com.souza.escola.dto.request.AlunoRequestDTO;
import com.souza.escola.entity.Aluno;
import com.souza.escola.response.AlunoResponseDTO;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlunoMapper {

	public Aluno toAluno(AlunoRequestDTO alunoDTO) {

		return Aluno.builder().nome(alunoDTO.getNome()).idade(alunoDTO.getIdade())
				.notaPrimeiroSemestre(alunoDTO.getNotaPrimeiroSemestre())
				.notaSegundoSemestre(alunoDTO.getNotaSegundoSemestre()).nomeProfessor(alunoDTO.getNomeProfessor())
				.numeroSala(alunoDTO.getNumeroSala()).build();
	}

	public AlunoResponseDTO toAlunoDTO(Aluno aluno) {
		return new AlunoResponseDTO(aluno);
	}

	public List<AlunoResponseDTO> toAlunoDTO(List<Aluno> alunoList) {
		return alunoList.stream().map(AlunoResponseDTO::new).collect(Collectors.toList());
	}

	public void updateAlunoData(Aluno aluno, AlunoRequestDTO alunoDTO) {

		aluno.setNome(alunoDTO.getNome());
		aluno.setIdade(alunoDTO.getIdade());
		aluno.setNotaPrimeiroSemestre(alunoDTO.getNotaPrimeiroSemestre());
		aluno.setNotaSegundoSemestre(alunoDTO.getNotaSegundoSemestre());
		aluno.setNomeProfessor(alunoDTO.getNomeProfessor());
		aluno.setNumeroSala(alunoDTO.getNumeroSala());

	}

}
