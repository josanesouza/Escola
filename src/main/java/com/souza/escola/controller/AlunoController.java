package com.souza.escola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.souza.escola.dto.request.AlunoRequestDTO;
import com.souza.escola.response.AlunoResponseDTO;
import com.souza.escola.service.AlunoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/escola")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoResponseDTO> findById(@PathVariable(name = "id") Long id) {
    	AlunoResponseDTO alunoDto = alunoService.findById(id);
    	if (alunoDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
    		return ResponseEntity.ok().body(alunoDto);

    	}

    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAll() {
    	List<AlunoResponseDTO> alunos = alunoService.findAll();
        
    	if (alunos == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
            return ResponseEntity.ok().body(alunos);


    	}
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> register(@RequestBody AlunoRequestDTO alunoRequestDTO, UriComponentsBuilder uriBuilder) {

        AlunoResponseDTO alunoResponseDTO = alunoService.register(alunoRequestDTO);

        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(alunoResponseDTO.getId()).toUri();
        
    	return  ResponseEntity.created(uri).body(alunoResponseDTO);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoResponseDTO> update(@RequestBody AlunoRequestDTO alunoDTO, @PathVariable(name = "id") Long id) {
    	AlunoResponseDTO alunoDto =   alunoService.update(id,alunoDTO);

    	if (alunoDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else {
            return ResponseEntity.ok().body(alunoService.update(id,alunoDTO));

    	}
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
    	
    	String alunoDto = alunoService.delete(id);

    	if (alunoDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
            return ResponseEntity.ok().body(alunoDto);

    	}
    	
    }

}
