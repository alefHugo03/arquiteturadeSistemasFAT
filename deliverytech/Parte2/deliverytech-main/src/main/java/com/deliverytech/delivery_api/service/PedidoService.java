package com.deliverytech.delivery_api.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.enums.StatusPedidos;
import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.ClienteRepository;
import com.deliverytech.delivery_api.repository.PedidoRepository;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@Service
public class PedidoService {
    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final RestauranteRepository restauranteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, RestauranteRepository restauranteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.restauranteRepository = restauranteRepository;
    }

    public Pedido criarPedido(@NonNull Long clienteId, @NonNull Long restauranteId){
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado."));

        Restaurante restaurante = restauranteRepository.findById(restauranteId)
            .orElseThrow(()-> new IllegalArgumentException("Restaurante não encontrado."));

        Pedido entradaPedido = new Pedido();
        entradaPedido.setCliente(cliente);
        entradaPedido.setRestaurante(restaurante);
        /* entradaPedido.setNumeroPedido(numeroPedido); */
        entradaPedido.setStatus(StatusPedidos.PENDENTE);
        entradaPedido.setDataPedido(LocalDateTime.now());
        entradaPedido.setValorTotal(BigDecimal.ZERO);
        return pedidoRepository.save(entradaPedido);
    }

    public Pedido atualizarStatus(@NonNull Long pedidoId, StatusPedidos status){
        Pedido pedido = pedidoRepository.findById(pedidoId)
        .orElseThrow(()-> new IllegalArgumentException("Pedido não encontrado."));

        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPorCliente(Long clienteId){
        return pedidoRepository.findByClienteId(clienteId);
    }
}
