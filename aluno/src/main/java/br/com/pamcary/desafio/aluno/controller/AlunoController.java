package br.com.pamcary.desafio.aluno.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pamcary.desafio.aluno.model.Aluno;
import br.com.pamcary.desafio.aluno.repository.AlunoRepository;

@RestController
@RequestMapping("/Aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Aluno cadastrar(@RequestBody @Valid Aluno aluno) {
		return repository.save(aluno);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> alterar(@PathVariable("id") long id, @RequestBody Aluno aluno) {
		return repository.findById(id).map(record -> {
			record.setNome(aluno.getNome());
			record.setIdade(aluno.getIdade());
			Aluno updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> excluir(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
