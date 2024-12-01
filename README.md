# Microserviço de Logística de Entregas

Este é um microserviço desenvolvido para gerenciar a logística de entregas, incluindo cadastro de entregadores, controle de status de entregas e monitoramento de localizações.

## 1. Introdução

O microserviço **ms-logistica-entrega** é responsável por:
- Cadastro e gerenciamento de entregadores.
- Controle de status e atualizações de entregas.
- Integração de rastreamento por latitude e longitude.

O projeto é construído com **Java (Spring Boot)** e utiliza **Maven** como gerenciador de dependências.

---

## 2. Pré-requisitos

Certifique-se de que os seguintes itens estão instalados:

- **Java 17+** ([Baixar](https://www.oracle.com/java/technologies/javase-downloads.html))
- **Maven 3.8+** ([Baixar](https://maven.apache.org/download.cgi))
- **Banco de dados**:
   - **H2** para testes
   - **MySQL** ou outro banco no ambiente de produção.

---

## 3. Configuração do Ambiente

### 3.1 Variáveis de Ambiente

O sistema utiliza variáveis configuradas em arquivos `application.properties` ou `application.yml`. Um exemplo básico para configuração local está abaixo:

```properties
# Configuração de Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/ms_logistica_entrega
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
