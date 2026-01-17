package com.deliverytech.delivery_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.deliverytech.delivery_api.enums.StatusPedidos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue; // Adicionado
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;             // Adicionado
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPedido;

    private String enderecoEntrega;

    private String numeroPedido;

    private BigDecimal taxaEntrega;
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedidos status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @OneToMany(mappedBy= "pedido", fetch = FetchType.LAZY)
    private List<ItemPedido> itens = new ArrayList<>();
}