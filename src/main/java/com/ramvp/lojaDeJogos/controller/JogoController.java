package com.ramvp.lojaDeJogos.controller;

import java.util.List;
import java.util.Optional;

import com.ramvp.lojaDeJogos.DTOs.MessageDTO;
import com.ramvp.lojaDeJogos.exception.jogo.JogoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ramvp.lojaDeJogos.model.Jogo;
import com.ramvp.lojaDeJogos.service.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@Autowired
	private JogoService service;

	@GetMapping("/all")
	public ResponseEntity<List<Jogo>> findAll() throws JogoNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Jogo> findById(@PathVariable int id) throws JogoNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Jogo>> findByNome(@PathVariable String nome) throws JogoNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNome(nome));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Jogo> save(@RequestBody Jogo jogo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(jogo));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Jogo> update(@RequestBody Jogo jogo) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(jogo));
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<MessageDTO> delete(@PathVariable int id) throws JogoNotFoundException {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("Jogo deletado com sucesso"));
	}
	
}
