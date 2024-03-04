package com.generation.ecofamily.controller;

import com.generation.ecofamily.dto.TransactionDTO;
import com.generation.ecofamily.model.Produto;
import com.generation.ecofamily.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comprar")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public void transacao(@Valid @RequestBody TransactionDTO transaction) {

        Produto produto = transaction.getProduto();

        if (transaction.getQuantidade() > produto.getQuantidade()) {
            throw new ArithmeticException("Quantidade maior que o estoque!");
        } else {
            Produto produtoLoja = new Produto(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), produto.getFoto(), produto.getCategoria(), produto.getUsuario(), produto.getData());
            produtoLoja.setQuantidade(produto.getQuantidade() - transaction.getQuantidade());

            produtoRepository.save(produtoLoja);


            Produto produtoComprado = new Produto(produto.getNome(), produto.getDescricao(), produto.getPreco(), transaction.getQuantidade(), produto.getFoto(), produto.getCategoria(), produto.getUsuario());
            produtoComprado.setUsuario(transaction.getComprador());
            produtoComprado.setQuantidade(transaction.getQuantidade());
            produtoComprado.setDescricao("Comprado de " + produtoLoja.getUsuario().getNome());

            produtoRepository.save(produtoComprado);

        }
    }
}
