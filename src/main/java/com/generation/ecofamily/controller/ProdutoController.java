package com.generation.ecofamily.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ecofamily.model.Produto;
import com.generation.ecofamily.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> findAllByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/precoMaiorIgual/{preco}")
    ResponseEntity<List<Produto>> findAllByPrecoGreaterThanEqual(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok(produtoRepository.findAllByPrecoGreaterThanEqual(preco));
    }

    @PutMapping
    public ResponseEntity<Produto> updateProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.findById(produto.getId())
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                        .body(produtoRepository.save(produto)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        produtoRepository.deleteById(id);
    }
}
