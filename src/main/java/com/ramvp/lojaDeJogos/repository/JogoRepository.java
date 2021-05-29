package com.ramvp.lojaDeJogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramvp.lojaDeJogos.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer>{
	
	List<Jogo> findByNomeContainingIgnoreCase(String nome);
	
	
}
