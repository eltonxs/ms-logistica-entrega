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

## Procedimentos para Rodar o Projeto
1. Instale o MySQL e configure o banco de dados `logistica_entrega`.
2. Configure o arquivo `application.properties` em `src/main/resources` com as credenciais do banco.
3. Use o Maven para compilar e rodar o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
