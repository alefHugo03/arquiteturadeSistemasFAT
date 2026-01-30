package com.deliverytech.delivery_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.service.ItemPedidoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item-pedidos")
public class ItemPedidoController {
    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, String> listaOpcoes(){
        return Map.of(
                "POST - adicionar","/adicionar",
                "DELETE - deletar","/{id}"
        );
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<ItemPedido> listarPorPedido(@PathVariable Long pedidoId){
        return service.listarPorPedido(pedidoId);
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
