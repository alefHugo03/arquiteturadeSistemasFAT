package com.deliverytech.delivery_api.config;


import com.deliverytech.delivery_api.enums.StatusPedidos;
import com.deliverytech.delivery_api.model.*;
import com.deliverytech.delivery_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner initData(
            ClienteRepository clienteRepository,
            RestauranteRepository restauranteRepository,
            ProdutoRepository produtoRepository,
            PedidoRepository pedidoRepository,
            ItemPedidoRepository itemPedidoRepository
    ){
        return args -> {
            System.out.println("Iniciando carregamento de dados");
            Cliente cliente1 = new Cliente();
            cliente1.setNome("Raiel Ladre");
            cliente1.setEmail("raiel@gmail.com");
            cliente1.setEndereco("Rua do Rio");

            cliente1.setAtivo(true);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Rio Grande");
            cliente2.setEmail("rio@gmail.com");
            cliente2.setEndereco("Rua do Rio");
            cliente2.setAtivo(true);

            List<Cliente>clientes =new ArrayList<>();
            clientes.add(cliente1);
            clientes.add(cliente2);

            clienteRepository.saveAll(clientes);
            System.out.println("Carregando Clientes");


            Restaurante restaurante1 = new Restaurante();
            restaurante1.setNome("Pizza Express");
            restaurante1.setCategoria("Italiana");
            restaurante1.setEndereco("Av. Principal, 100");
            restaurante1.setTelefone("1133333333");
            restaurante1.setTaxaEntrega(new BigDecimal("3.50"));
            restaurante1.setAtivo(true);

            Restaurante restaurante2 = new Restaurante();
            restaurante2.setNome("Burger King");
            restaurante2.setCategoria("Fast Food");
            restaurante2.setEndereco("Rua Secundária, 200");
            restaurante2.setTelefone("1144444444");
            restaurante2.setTaxaEntrega(new BigDecimal("5.00"));
            restaurante2.setAtivo(true);

            List<Restaurante>restaurantes =new ArrayList<>();
            restaurantes.add(restaurante1);
            restaurantes.add(restaurante2);

            restauranteRepository.saveAll(restaurantes);
            System.out.println("Carregando Restaurantes");


            Produto produto1 = new Produto();
            produto1.setNome("Pizza de Calabresa");
            produto1.setDescricao("Deliciosa Pizza de calabresa com borda recheada");
            produto1.setPreco(new BigDecimal("45.00"));
            produto1.setCategoria("Pizza");
            produto1.setDisponivel(true);
            produto1.setRestaurante(restaurante1);

            Produto produto2 = new Produto();
            produto2.setNome("Hambúrguer Clássico");
            produto2.setDescricao("Pão, alface, tomate e hambúrguer");
            produto2.setPreco(new BigDecimal("25.00"));
            produto2.setCategoria("Hambúrguer");
            produto2.setDisponivel(true);
            produto2.setRestaurante(restaurante2);

            List<Produto>produtos =new ArrayList<>();
            produtos.add(produto1);
            produtos.add(produto2);

            produtoRepository.saveAll(produtos);
            System.out.println("Carregando Produtos");


            Pedido pedido1 = new Pedido();
            pedido1.setCliente(cliente1);
            pedido1.setRestaurante(restaurante1);
            pedido1.setStatus(StatusPedidos.PENDENTE);
            pedido1.setEnderecoEntrega(cliente1.getEndereco());
            pedido1.setValorTotal(BigDecimal.ZERO);

            Pedido pedido2 = new Pedido();
            pedido2.setCliente(cliente2);
            pedido2.setRestaurante(restaurante2);
            pedido2.setStatus(StatusPedidos.PENDENTE);
            pedido2.setEnderecoEntrega(cliente2.getEndereco());
            pedido2.setValorTotal(BigDecimal.ZERO);


            List<Pedido>pedidos =new ArrayList<>();
            pedidos.add(pedido1);
            pedidos.add(pedido2);

            pedidoRepository.saveAll(pedidos);
            System.out.println("Enviando Pedido");


            ItemPedido itemPedido1 = new ItemPedido();
            itemPedido1.setProduto(produto1);
            itemPedido1.setPedido(pedido1);
            itemPedido1.setQuantidade(1);
            itemPedido1.setPrecoUnitario(produto1.getPreco());
            itemPedido1.setSubtotal(produto1.getPreco().multiply(BigDecimal.valueOf(itemPedido1.getQuantidade())));

            ItemPedido itemPedido2 = new ItemPedido();
            itemPedido2.setProduto(produto2);
            itemPedido2.setPedido(pedido2);
            itemPedido2.setQuantidade(2);
            itemPedido2.setPrecoUnitario(produto2.getPreco());
            itemPedido2.setSubtotal(produto2.getPreco().multiply(BigDecimal.valueOf(itemPedido2.getQuantidade())));

            List<ItemPedido>itensPedidos =new ArrayList<>();
            itensPedidos.add(itemPedido1);
            itensPedidos.add(itemPedido2);

            itemPedidoRepository.saveAll(itensPedidos);
            System.out.println("Itens Pedidos");

        };
    }
}
