# Delivery Tech API
Sistema de delivery desenvolvido com Spring Boot e Java 21.

## 🏫 Sobre o Projeto
API REST completa para gestão de um ecossistema de delivery. O sistema permite o cadastro de clientes e restaurantes, gerenciamento de cardápios (produtos) e o ciclo de vida de pedidos (criação, adição de itens e atualização de status).

## 🚀 Tecnologias
- **Java 21 LTS** (versão mais recente)
- Spring Boot 3.2.x
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## ⚡ Recursos Modernos Utilizados
- Records (Java 14+)
- Text Blocks (Java 15+)
- Pattern Matching (Java 17+)
- Virtual Threads (Java 21)

## ⚙️ Funcionalidades
- **Gestão de Clientes**: Cadastro, atualização, busca e remoção.
- **Gestão de Restaurantes**: Cadastro de estabelecimentos e categorias.
- **Catálogo de Produtos**: Vinculação de produtos aos restaurantes.
- **Sistema de Pedidos**:
  - Abertura de pedidos para clientes em restaurantes específicos.
  - Adição e remoção de itens no pedido.
  - Controle de status do pedido (ex: EM_PREPARO).

## 🏃‍♂️ Como executar
1. **Pré-requisitos:** JDK 21 instalado
2. Clone o repositório
3. Execute: `./mvnw spring-boot:run`
4. Acesse: http://localhost:8080/health

## 📋 Guia de Uso da API
A aplicação expõe endpoints REST para todos os recursos.

> **Dica:** Consulte o arquivo `TESTES.txt` na raiz do projeto para um roteiro passo a passo de como testar todas as funcionalidades via cURL ou Postman.

Principais recursos:
- `/clientes`
- `/restaurantes`
- `/produtos`
- `/pedidos`
- `/health` (Verificação de saúde)

## 🔧 Configuração
- Porta: 8080
- Banco: H2 em memória
- Profile: development

## 👨‍💻 Desenvolvedor
**Alef Hugo** - Turma 2602 - Arquitetura de Sistemas
Desenvolvido com JDK 21 e Spring Boot 3.2.x