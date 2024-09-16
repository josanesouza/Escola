package com.souza.escola.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.souza.escola.dto.request.AlunoRequestDTO;
import com.souza.escola.entity.Aluno;
import com.souza.escola.repository.AlunoRepository;
import com.souza.escola.response.AlunoResponseDTO;
import com.souza.escola.util.AlunoMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;


    @Override
    public AlunoResponseDTO findById(Long id) {
     return alunoMapper.toAlunoDTO(returnAluno(id));
    }

    @Override
    public List<AlunoResponseDTO> findAll() {
        return alunoMapper.toAlunoDTO(alunoRepository.findAll());
    }

    @Override
    public AlunoResponseDTO register(AlunoRequestDTO alunoDTO) {

        Aluno aluno = alunoMapper.toAluno(alunoDTO);

        return alunoMapper.toAlunoDTO(alunoRepository.save(aluno));
    }

    @Override
    public AlunoResponseDTO update(Long id, AlunoRequestDTO alunoDTO) {

        Aluno aluno = returnAluno(id);

        alunoMapper.updateAlunoData(aluno, alunoDTO);

        return alunoMapper.toAlunoDTO(alunoRepository.save(aluno));
    }

    @Override
    public String delete(Long id) {
        alunoRepository.deleteById(id);
        return "Aluno id: "+id+" deleted";
    }

    private Aluno returnAluno(Long id) {
       return alunoRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Aluno wasn't fount on database"));
    }

}
