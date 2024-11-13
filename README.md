# Projeto ms-logistica-entrega

Microserviço de Logística e Entrega para gerenciar entregadores, pedidos e status de entregas.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- MySQL
- OpenFeign para comunicação entre microserviços
- Docker (opcional)
- Maven
- Swagger UI (documentação da API)

## Documentação da API com Swagger
A documentação interativa da API é gerada automaticamente com o Swagger e pode ser acessada após iniciar o projeto.

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Documentação OpenAPI (JSON)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## Procedimentos para Rodar o Projeto
1. Instale o MySQL e configure o banco de dados `logistica_entrega`.
2. Configure o arquivo `application.properties` em `src/main/resources` com as credenciais do banco.
3. Use o Maven para compilar e rodar o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
