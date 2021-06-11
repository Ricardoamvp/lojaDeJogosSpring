package com.ramvp.lojaDeJogos.service;

import com.ramvp.lojaDeJogos.exception.categoria.CategoriaNotFoundException;
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

    public Categoria findById(Integer id) throws CategoriaNotFoundException {
        Optional<Categoria> a = repository.findById(id);
        if(a.isEmpty())
            throw new CategoriaNotFoundException("teste humilde");
        else
        return a.get();
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
