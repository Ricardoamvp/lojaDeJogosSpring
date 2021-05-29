package com.ramvp.lojaDeJogos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramvp.lojaDeJogos.model.Jogo;
import com.ramvp.lojaDeJogos.service.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@Autowired
	private JogoService service;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Jogo>> findById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Jogo>> findByNome(@PathVariable String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNome(nome));
	}
	
	@GetMapping("/salvar")
	public ResponseEntity<Jogo> save(@RequestBody Jogo jogo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(jogo));
	}
	
	@GetMapping("/atualizar")
	public ResponseEntity<Jogo> update(@RequestBody Jogo jogo) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(jogo));
	}
	
	@GetMapping("/deletar/{id}")
	public ResponseEntity<Jogo> delete(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).build(service.delete(id));
	}
	
}
