package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@Service
@Transactional
public class RestauranteService {
    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    public Restaurante Cadastrar(Restaurante dados) {
        dados.setAtivo(true);
        return repository.save(dados);
    }

    public List<Restaurante> listarAtivos() {
        return repository.findByAtivoTrue();
    }

    public List<Restaurante> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaAndAtivoTrue(categoria);
    }

    public Restaurante buscarPorId(long id) {
        return repository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }

    public void desativar(long id) {
        Restaurante restaurante = buscarPorId(id);
        restaurante.setAtivo(false);
        repository.save(restaurante);
    }
}
