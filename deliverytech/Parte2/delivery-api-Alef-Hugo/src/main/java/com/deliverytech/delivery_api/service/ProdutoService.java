package com.deliverytech.delivery_api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.ProdutoRepository;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final RestauranteRepository restauranteRepository;

    public ProdutoService(ProdutoRepository produtoRepository, RestauranteRepository restauranteRepository) {
        this.produtoRepository = produtoRepository;
        this.restauranteRepository = restauranteRepository;
    }
    
    public Produto cadastrar(long restauranteId, Produto produto) {
        if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw  new IllegalArgumentException("O preço inválido");
        }
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
            .orElseThrow(()-> new IllegalArgumentException("Restaurante não encontrado"));

        produto.setDisponivel(true);
        produto.setRestaurante(restaurante);

        return produtoRepository.save(produto);
    }

    public List<Produto> listarPorRestaurante(long restauranteId) {
        return produtoRepository.findByRestauranteIdAndDisponivelTrue(restauranteId);
    }
    
}