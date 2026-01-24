package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.dto.TotalVendasPorRestauranteDTO;
import com.deliverytech.delivery_api.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
@RequiredArgsConstructor
public class RelatorioController {
    private final RelatorioService relatorioService;

    @GetMapping("/total-vendas-por-restaurante")
    public List<TotalVendasPorRestauranteDTO>  totalVendasPorRestaurante() {
        return relatorioService.totalVendasPorRestaurante();
    }
}
