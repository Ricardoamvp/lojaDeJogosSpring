package com.ramvp.lojaDeJogos.controller;

import com.ramvp.lojaDeJogos.model.Categoria;
import com.ramvp.lojaDeJogos.service.CategoriaService;
import com.ramvp.lojaDeJogos.util.PayloadMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Optional<Categoria> c = service.findById(id);

        if(c.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(c.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Categoria>> findByNome(String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByNome(nome));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(categoria));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<PayloadMessage> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadMessage("Categoria deletada com sucesso"));
    }

}
