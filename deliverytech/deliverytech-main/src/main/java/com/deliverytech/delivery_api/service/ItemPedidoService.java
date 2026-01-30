package com.deliverytech.delivery_api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.repository.ItemPedidoRepository;
import com.deliverytech.delivery_api.repository.PedidoRepository;
import com.deliverytech.delivery_api.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoService(ItemPedidoRepository repository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<ItemPedido> listarPorPedido(Long pedidoId){
        return repository.findByPedidoId(pedidoId);
    }

    public ItemPedido adicionarItem(@NonNull Long pedidoId, @NonNull Long produtoId, Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));

        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        ItemPedido item = new ItemPedido();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(quantidade);
        item.setPrecoUnitario(produto.getPreco());

        BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        item.setSubtotal(subtotal);
        
        repository.save(item);

        pedido.setValorTotal(pedido.getValorTotal().add(subtotal));
        pedidoRepository.save(pedido);

        return item;
    }

    public void removerItem(@NonNull Long id) {
        ItemPedido item = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Item do pedido não encontrado."));
        
        Pedido pedido = item.getPedido();
        pedido.setValorTotal(pedido.getValorTotal().subtract(item.getSubtotal()));
        pedidoRepository.save(pedido);
        
        repository.delete(item);
    }
}
