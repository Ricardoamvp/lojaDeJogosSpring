package com.ramvp.lojaDeJogos.repository;

import com.ramvp.lojaDeJogos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    List<Categoria> findByNomeContainingIgnoreCase(String nome);
}
