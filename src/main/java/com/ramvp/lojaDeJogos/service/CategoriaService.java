package com.ramvp.lojaDeJogos.service;

import com.ramvp.lojaDeJogos.model.Categoria;
import com.ramvp.lojaDeJogos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {

        return repository.findAll();
    }

    public Optional<Categoria> findById(Integer id) {

        return repository.findById(id);
    }

    public List<Categoria> findByNome(String nome) {

        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Categoria save(Categoria categoria) {

        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria) {

        return repository.save(categoria);
    }

    public void delete(Integer id) {

        repository.deleteById(id);
    }

}
