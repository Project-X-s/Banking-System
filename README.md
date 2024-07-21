# Banking System

Este repositório contém um exemplo de sistema bancário desenvolvido em Java com Spring Boot, utilizando MS SQL Server como banco de dados. O sistema permite a criação de carteiras de usuários, validação de transações e integração com serviços externos de autorização e notificação.

## Estrutura do Projeto

- **Backend (Spring Boot)**: Implementa uma API RESTful com endpoints para criação de carteiras de usuários e validação de transações. O backend é integrado a um banco de dados MS SQL Server executado em um contêiner Docker.

## Funcionalidades Principais

1. **Endpoints da API**:

   - **Criação de Carteira**:
     - `POST /wallets`: Cria uma nova carteira de usuário.
   - **Criação de Usuário**:
     - `POST /create/user`: Cria um novo usuário.
   - **Validação de Transações**:
     - `POST /transition`: Verifica e realiza uma transação com base nas informações fornecidas.

2. **Integração com Serviços Externos**:
   - **Serviço de Autorização**:
     - URL: `https://util.devi.tools/api/v2/authorize`
   - **Serviço de Notificação**:
     - URL: `https://util.devi.tools/api/v1/notify`

## Como Executar o Projeto

1. **Configurar o MS SQL Server**:

   - Certifique-se de ter Docker e Docker Compose instalados.
   - Use o Docker Compose para iniciar o contêiner MS SQL Server.
     ```bash
     docker-compose up -d
     ```

2. **Backend (Spring Boot)**:

   - Certifique-se de ter o Java e o Maven instalados.
   - Configure as propriedades de conexão com o banco de dados no arquivo `application.properties`.
   - Navegue até o diretório do projeto e compile a aplicação com Maven:
     ```bash
     mvn clean install
     ```
   - Inicie a aplicação Spring Boot:
     ```bash
     mvn spring-boot:run
     ```

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de aplicações Java.
- **MS SQL Server**: Banco de dados relacional utilizado para armazenamento de dados.
- **Docker**: Plataforma para containerização do MS SQL Server.

## Contribuição

Contribuições são bem-vindas! Para sugestões ou problemas encontrados, abra uma issue neste repositório.

---

Desenvolvido por [Sant-Thiago](https://github.com/Sant-Thiago)

refs [Build & Run](https://www.youtube.com/watch?v=dttXo48oXt4)
