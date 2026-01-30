package com.deliverytech.delivery_api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.dto.TotalVendasPorRestauranteDTO;
import com.deliverytech.delivery_api.enums.StatusPedidos;
import com.deliverytech.delivery_api.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByStatus(StatusPedidos status);

    @Query("""
            SELECT p FROM Pedido p
            WHERE p.dataPedido BETWEEN :inicio AND :fim
    """)
    List<Pedido> findByDateTime(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim
    );

    // FIXED QUERY BELOW
    @Query("""
        SELECT new com.deliverytech.delivery_api.dto.TotalVendasPorRestauranteDTO(
            p.restaurante.nome,
            COALESCE(SUM(ip.subtotal), 0)
        )
        FROM Pedido p
        JOIN p.itens ip
        WHERE p.status = 'ENTREGUE'  
        GROUP BY p.restaurante.nome
    """)
    List<TotalVendasPorRestauranteDTO> totalVendasPorRestaurante();

    @Query(value= """
        SELECT c.nome AS cliente, count(p.id) as total_pedidos
        FROM pedidos p
        JOIN clientes c on c.id = p.cliente_id
        GROUP BY c.nome
        ORDER BY total_pedidos DESC
    """, nativeQuery = true)
    List<Object[]> rankingClientes();
}