package com.souza.escola.service;


import com.souza.escola.dto.request.AlunoRequestDTO;
import com.souza.escola.response.AlunoResponseDTO;

import java.util.List;

public interface AlunoService {

    AlunoResponseDTO findById(Long id);

    List<AlunoResponseDTO> findAll();

    AlunoResponseDTO register(AlunoRequestDTO personDTO);

    AlunoResponseDTO update(Long id, AlunoRequestDTO personDTO);

    String delete(Long id);

}
