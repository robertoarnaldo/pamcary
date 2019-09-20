package br.com.pamcary.desafio.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pamcary.desafio.aluno.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}