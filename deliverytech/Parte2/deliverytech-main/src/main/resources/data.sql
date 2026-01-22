-- 1. CLIENTES (O banco vai gerar IDs 1, 2 e 3 nesta ordem)
INSERT INTO clientes (nome, email, telefone, endereco, data_cadastro, ativo) VALUES
('João Silva', 'joao@email.com', '(11) 99999-1111', 'Rua A, 123 - São Paulo/SP', CURRENT_TIMESTAMP, true),
('Maria Santos', 'maria@email.com', '(11) 99999-2222', 'Rua B, 456 - São Paulo/SP', CURRENT_TIMESTAMP, true),
('Pedro Oliveira', 'pedro@email.com', '(11) 99999-3333', 'Rua C, 789 - São Paulo/SP', CURRENT_TIMESTAMP, true);

-- 2. RESTAURANTES (O banco vai gerar IDs 1, 2 e 3 nesta ordem)
INSERT INTO restaurantes (nome, categoria, endereco, telefone, taxa_entrega, avaliacao, ativo) VALUES
('Pizzaria Bella', 'Italiana', 'Av. Paulista, 1000 - São Paulo/SP', '(11) 3333-1111', 5.00, 4.5, true),
('Burger House', 'Hamburgueria', 'Rua Augusta, 500 - São Paulo/SP', '(11) 3333-2222', 3.50, 4.2, true),
('Sushi Master', 'Japonesa', 'Rua Liberdade, 200 - São Paulo/SP', '(11) 3333-3333', 8.00, 4.8, true);

-- 3. PRODUTOS (IDs gerados de 1 a 8 automaticamente)
INSERT INTO produtos (nome, descricao, categoria, preco, disponivel, restaurante_id) VALUES
('Pizza Margherita', 'Molho de tomate, mussarela e manjericão', 'Pizza', 35.90, true, 1),    -- ID 1
('Pizza Calabresa', 'Molho de tomate, mussarela e calabresa', 'Pizza', 38.90, true, 1),      -- ID 2
('Lasanha Bolonhesa', 'Lasanha tradicional com molho bolonhesa', 'Massa', 28.90, true, 1),   -- ID 3
('X-Burger', 'Hambúrguer, queijo, alface e tomate', 'Hambúrguer', 18.90, true, 2),           -- ID 4
('X-Bacon', 'Hambúrguer, queijo, bacon, alface e tomate', 'Hambúrguer', 22.90, true, 2),     -- ID 5
('Batata Frita', 'Porção de batata frita crocante', 'Acompanhamento', 12.90, true, 2),       -- ID 6
('Combo Sashimi', '15 peças de sashimi variado', 'Sashimi', 45.90, true, 3),                 -- ID 7
('Hot Roll Salmão', '8 peças de hot roll de salmão', 'Hot Roll', 32.90, true, 3);            -- ID 8

-- 4. PEDIDOS (IDs gerados de 1 a 3)
INSERT INTO pedidos (data_pedido, endereco_entrega, numero_pedido, taxa_entrega, valor_total, status, cliente_id, restaurante_id) VALUES
(CURRENT_TIMESTAMP, 'Rua A, 123', 'PED1234567890', 5.00, 64.80, 'PENDENTE', 1, 1),   -- ID 1
(CURRENT_TIMESTAMP, 'Rua B, 456', 'PED1234567891', 7.00, 41.80, 'CONFIRMADO', 2, 2),  -- ID 2
(CURRENT_TIMESTAMP, 'Rua C, 789', 'PED1234567892', 6.00, 78.80, 'ENTREGUE', 3, 3);    -- ID 3

INSERT INTO itens_pedido (quantidade, preco_unitario, subtotal, pedido_id, produto_id) VALUES
(1, 35.90, 35.90, 1, 1),
(1, 28.90, 28.90, 1, 3),
(1, 22.90, 22.90, 2, 5),
(1, 18.90, 18.90, 2, 4),
(1, 45.90, 45.90, 3, 7),
(1, 32.90, 32.90, 3, 8);