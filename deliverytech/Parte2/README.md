# Delivery Tech API

API REST desenvolvida para um sistema de delivery, utilizando as práticas modernas do ecossistema Java com Spring Boot.

## 🏫 Sobre o Projeto
Este projeto foi desenvolvido como parte das atividades do curso de **Arquitetura de Software** na **Fundação FAT**.

**Objetivo:** Desenvolver um sistema que siga boas práticas de engenharia de software, servindo como material de estudo e referência para demonstrar o uso de Java 21, Records e banco de dados em memória.

## 🚀 Tecnologias Utilizadas

- **Java 21 LTS**: Versão mais recente com suporte a longo prazo.
- **Spring Boot 3.2.x**: Framework para criação de aplicações Java robustas.
- **Spring Web**: Para construção de APIs RESTful.
- **Spring Data JPA**: Abstração para persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento rápido.
- **Lombok**: Biblioteca para redução de código boilerplate.
- **Maven**: Gerenciamento de dependências e build.

## ⚡ Destaques do Código

O projeto explora recursos modernos da linguagem Java:
- **Records** (Java 14+): Utilizados para DTOs e transporte de dados imutáveis.
- **Text Blocks** (Java 15+): Para formatação de strings multilinhas.
- **Pattern Matching** (Java 17+): Simplificação de verificações de tipos.
- **Virtual Threads** (Java 21): Preparado para alta concorrência.

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- JDK 21 instalado.
- Maven (opcional, pois o projeto inclui o Maven Wrapper).

### Passos
1. Clone este repositório.
```bash
   git clone https://github.com/alefHugo03/arquiteturadeSistemasFAT.git
   ```
2. Acesse a pasta do projeto via terminal.
```bash
   cd deliverytech/Parte2/delivery-api
   ```
3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```
4. A aplicação estará rodando em: `http://localhost:8080`

## ⚙️ Configurações Importantes (Dicas)

Para garantir o funcionamento correto do banco de dados em memória (H2) com scripts de inicialização, foram aplicadas as seguintes configurações no `application.properties`:

- **Criação de Tabelas vs Dados:**
  Utilizamos `spring.jpa.defer-datasource-initialization=true` para garantir que o Hibernate crie as tabelas **antes** de o Spring tentar rodar scripts de dados (como `data.sql`).

- **Inicialização SQL:**
  A propriedade `spring.sql.init.mode=always` força a execução dos scripts de inicialização em cada reinicialização da aplicação.

## 📚 Documentação da API (Endpoints)

Abaixo estão os endpoints disponíveis para verificação e monitoramento da API.

### 1. Status Simples
Verifica se a aplicação está respondendo.
- **Método:** `GET`
- **URL:** `/`
- **Exemplo de Resposta:**
  ```json
  {
    "nome": "Alef",
    "timestamp": "2024-01-19T19:30:00.123456"
  }
  ```

### 2. Health Check
Retorna o status detalhado da saúde da aplicação e versão do ambiente Java.
- **Método:** `GET`
- **URL:** `/health`
- **Exemplo de Resposta:**
  ```json
  {
    "status": "UP",
    "timestamp": "2024-01-19T19:30:05.123456",
    "service": "Delivery API",
    "javaVersion": "21.0.2"
  }
  ```

### 3. Informações da Aplicação
Retorna metadados sobre o projeto, desenvolvedor e tecnologias.
- **Método:** `GET`
- **URL:** `/info`
- **Exemplo de Resposta:**
  ```json
  {
    "application": "Delivery Tech API",
    "version": "1.0.0",
    "developer": "Alef Hugo",
    "javaVersion": "JDK 21",
    "framework": "Spring Boot 3.2.x"
  }
  ```

## 🗄️ Banco de Dados (H2 Console)

O projeto utiliza o banco H2 em memória. Para acessar o console de gerenciamento:

1. Acesse no navegador: `http://localhost:8080/h2-console`
2. Utilize as credenciais configuradas:
   - **JDBC URL:** `jdbc:h2:mem:deliverydb`
   - **User Name:** `sa`
   - **Password:** (deixe em branco)

## �‍💻 Desenvolvedor
**Alef Hugo** - Turma 2602  
Desenvolvido com JDK 21 e Spring Boot 3.2.x na Fundação FAT.