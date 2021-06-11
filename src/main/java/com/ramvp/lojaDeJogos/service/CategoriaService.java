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

    public List<Categoria> findAll() throws CategoriaNotFoundException {
        List<Categoria> listaDeCategorias = repository.findAll();
        if (listaDeCategorias.isEmpty())
            throw new CategoriaNotFoundException("Nenhuma categoria encontrada");
        else
            return listaDeCategorias;
    }

    public Categoria findById(Integer id) throws CategoriaNotFoundException {
        Optional<Categoria> a = repository.findById(id);
        if (a.isEmpty())
            throw new CategoriaNotFoundException("Não existe nenhuma categoria com esse id");
        else
            return a.get();
    }

    public List<Categoria> findByNome(String nome) throws CategoriaNotFoundException {
        List<Categoria> a = repository.findByNomeContainingIgnoreCase(nome);
        if (a.isEmpty())
            throw new CategoriaNotFoundException("Não existem categorias com esse nome");
        else
            return a;
    }

    public Categoria save(Categoria categoria) {

        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria) {

        return repository.save(categoria);
    }

    public void delete(Integer id) throws CategoriaNotFoundException {
        Categoria delete = findById(id);
        repository.delete(delete);
    }

}
