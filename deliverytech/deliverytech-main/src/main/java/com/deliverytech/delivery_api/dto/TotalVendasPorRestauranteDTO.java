package com.deliverytech.delivery_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class TotalVendasPorRestauranteDTO {
    private String restaurante;
    private BigDecimal totalVendas;

    public TotalVendasPorRestauranteDTO(String restaurante, BigDecimal totalVendas) {
        this.restaurante = restaurante;
        this.totalVendas = totalVendas;
    }

}