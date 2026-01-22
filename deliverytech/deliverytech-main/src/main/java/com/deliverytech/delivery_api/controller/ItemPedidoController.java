package com.deliverytech.delivery_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.service.ItemPedidoService;

@RestController
@RequestMapping("/item-pedidos")
public class ItemPedidoController {
    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service) {
        this.service = service;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ItemPedido> adicionarItem(
            @NonNull @RequestParam Long pedidoId, 
            @NonNull @RequestParam Long produtoId, 
            @RequestParam Integer quantidade) {
        return ResponseEntity.status(201).body(service.adicionarItem(pedidoId, produtoId, quantidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerItem(@NonNull @PathVariable Long id) {
        service.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}
