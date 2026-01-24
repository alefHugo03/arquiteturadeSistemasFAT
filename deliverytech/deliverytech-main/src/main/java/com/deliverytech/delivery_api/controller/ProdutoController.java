package com.deliverytech.delivery_api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService  produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public Map<String, String> listaOpcoes(){
        return Map.of(
                "POST - cadastrar","/{restauranteId}",
                "GET - listar por restaurante","/restaurante/{restauranteId}"
        );
    }

    @PostMapping("/{restauranteId}")
    public ResponseEntity<Produto> cadastrar(@NonNull @PathVariable Long restauranteId, @RequestBody Produto produto){
        return ResponseEntity.status(201).body(produtoService.cadastrar(restauranteId, produto));
    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<Produto>> listarPorRestaurante(@PathVariable Long restauranteId){
        return ResponseEntity.ok(produtoService.listarPorRestaurante(restauranteId));
    }

}
