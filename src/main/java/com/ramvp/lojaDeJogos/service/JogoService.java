package com.ramvp.lojaDeJogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramvp.lojaDeJogos.model.Jogo;
import com.ramvp.lojaDeJogos.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository repository;
	
	public List<Jogo> findAll() {
		return repository.findAll();
	}
	
	public Optional<Jogo> findById(int id) {
		return repository.findById(id);
	}
	
	public List<Jogo> findByNome(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Jogo update (Jogo jogo) {
		return repository.save(jogo);
	}
	
	public Jogo save (Jogo jogo) {
		return repository.save(jogo);
	}
	
	public void delete (Integer id) {
		repository.deleteById(id);
	}

}
