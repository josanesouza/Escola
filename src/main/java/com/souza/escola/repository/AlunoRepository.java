package com.souza.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souza.escola.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
