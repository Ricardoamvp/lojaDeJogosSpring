package com.ramvp.lojaDeJogos.service;

import java.util.List;
import java.util.Optional;

import com.ramvp.lojaDeJogos.exception.jogo.JogoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramvp.lojaDeJogos.model.Jogo;
import com.ramvp.lojaDeJogos.repository.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;

	public List<Jogo> findAll() throws JogoNotFoundException {
		List<Jogo> listaJogos = repository.findAll();

		if (listaJogos.isEmpty())
			throw new JogoNotFoundException("Nenhum jogo encontrado");

		return listaJogos;
	}

	public Jogo findById(int id) throws JogoNotFoundException {
		Optional<Jogo> jogo = repository.findById(id);

		if (jogo.isEmpty())
			throw new JogoNotFoundException("Não existe nenhum jogo com esse ID");

		return jogo.get();
	}

	public List<Jogo> findByNome(String nome) throws JogoNotFoundException {
		List<Jogo> listaJogos = repository.findByNomeContainingIgnoreCase(nome);

		if (listaJogos.isEmpty())
			throw new JogoNotFoundException("Não existe nenhum jogo com esse nome");

		return repository.findByNomeContainingIgnoreCase(nome);
	}

	public Jogo save(Jogo jogo) {
		return repository.save(jogo);
	}

	public Jogo update(Jogo jogo) {
		return repository.save(jogo);
	}

	public void delete(Integer id) throws JogoNotFoundException {
		Jogo jogo = findById(id);
		repository.delete(jogo);
	}

}
