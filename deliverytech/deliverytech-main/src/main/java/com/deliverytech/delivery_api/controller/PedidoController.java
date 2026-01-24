package com.deliverytech.delivery_api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.enums.StatusPedidos;
import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public Map<String, String> listaOpcoes(){
        return Map.of(
                "POST - criar","/criar",
                "GET - listar por cliente","/cliente/{id}",
                "PUT - atualizar status","/{id}/status"
        );
    }


    @PostMapping("/criar")
    public Pedido criarPedido(@NonNull @RequestParam Long clienteId, @NonNull  @RequestParam Long restauranteId){
        return pedidoService.criarPedido(clienteId, restauranteId);
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@NonNull @PathVariable Long id, @RequestParam StatusPedidos status){
        return pedidoService.atualizarStatus(id, status);
    }

    @GetMapping("/cliente/{id}")
    public List<Pedido> listarPorCliente(@PathVariable Long id){
        return pedidoService.listarPorCliente(id);
    }

}
