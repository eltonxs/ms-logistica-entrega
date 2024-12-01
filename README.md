Microserviço de Logística de Entrega

Este é um microserviço desenvolvido para gerenciar a logística de entregas, incluindo cadastro de entregadores, controle de status de entregas e monitoramento de localizações.

1. Introdução
   O microserviço ms-logistica-entrega é responsável por:

Cadastro e gerenciamento de Entrega e Entregadores.
Controle de status e atualizações de entregas.
Monitoramento de localização (latitude e longitude).
Integração com notificações para clientes e entregadores.
O projeto é construído com Java (Spring Boot) e utiliza Maven como gerenciador de dependências.


2. Link do Projeto no GitHub
   O código fonte deste microserviço está disponível no seguinte repositório: https://github.com/eltonxs/ms-logistica-entrega



Aqui está o conteúdo atualizado do README.md com as informações que você solicitou, incluindo detalhes sobre como acessar o Swagger e informações adicionais de execução e configuração:

Microserviço de Logística de Entrega
Este é um microserviço desenvolvido para gerenciar a logística de entregas, incluindo cadastro de entregadores, controle de status de entregas e monitoramento de localizações.

3. Pré-requisitos
Certifique-se de que os seguintes itens estão instalados:

Java 17+ (Baixar)
Maven 3.8+ (Baixar)
Spring Cloud Stream
Spring Data JPA
Spring Documentation
Spring Cloud
Feign
Banco de dados:
H2 para testes
MySQL ou outro banco no ambiente de produção.

4. Configuração do Ambiente
   4.1 Variáveis de Ambiente
   O sistema utiliza variáveis configuradas em arquivos application.properties ou application.yml. Um exemplo básico para configuração local está abaixo:

properties
Copiar código
# Configuração de Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3307/logistica_entrega
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
4.2 Configuração do Swagger
Para acessar a documentação da API (Swagger), utilize o seguinte link após iniciar o microserviço:

http://localhost:8080/swagger-ui/index.html

5. Como Executar o Projeto
   5.1 Clonar o repositório
   bash
   Copiar código
   git clone https://github.com/eltonxs/ms-logistica-entrega
   cd ms-logistica-entrega
   5.2 Build do Projeto
   No diretório raiz do projeto, execute:

bash
Copiar código
make build-project

6. Executar o Projeto
   Após o build, para executar o projeto localmente:

bash
Copiar código
make run

7. Com Tabela Markdown
      markdown
      Copiar código
## 5. Endpoints Principais

| Funcionalidade                | Método | Endpoint                     | Descrição                                                                 |
|-------------------------------|--------|------------------------------|---------------------------------------------------------------------------|
| **Cadastro de Entregador**    | POST   | `/entregadores`              | Permite cadastrar um entregador com nome, CPF e telefone.                 |
| **Atualização de Entregador** | PUT    | `/entregadores/{id}`         | Atualiza informações de um entregador existente.                          |
| **Rastreamento de Entregas**  | PUT    | `/entregas/{id}/localizacao` | Atualiza a localização geográfica da entrega (latitude e longitude).      |
| **Atualização de Status**     | PUT    | `/entregas/{id}/status`      | Atualiza o status da entrega (pendente, em andamento, finalizada).        |
| **Listagem de Entregadores**  | GET    | `/entregadores`              | Retorna todos os entregadores cadastrados.                                |
| **Cadastro de Pedido**        | POST   | `/entregas`                  | Permite cadastrar um pedido com status, entregadorId,dataCriacao,endereço |
| **Listagem de Pedido**        | GET    | `/entregas`                  | Retorna todos os pedidos cadastrados.                                     |

### 🚚 **Cadastro de Entregador**
- **Método**: POST
- **Endpoint**: `/entregadores`
- **Descrição**: Permite cadastrar um entregador com nome, CPF e telefone.

---

### ✏️ **Atualização de Entregador**
- **Método**: PUT
- **Endpoint**: `/entregadores/{id}`
- **Descrição**: Atualiza informações de um entregador existente.

---

### 📍 **Rastreamento de Entregas**
- **Método**: PUT
- **Endpoint**: `/entregas/{id}/localizacao`
- **Descrição**: Atualiza a localização geográfica da entrega (latitude e longitude).

---

### 🔄 **Atualização de Status**
- **Método**: PUT
- **Endpoint**: `/entregas/{id}/status`
- **Descrição**: Atualiza o status da entrega (pendente, em andamento, finalizada).

---

### 📋 **Listagem de Entregadores**
- **Método**: GET
- **Endpoint**: `/entregadores`
- **Descrição**: Retorna todos os entregadores cadastrados.

### 🚚 **Cadastro de Entregador**
- **Método**: POST
- **Endpoint**: `/entregas`
- **Descrição**: Permite cadastrar um pedido com status, entregadorId,dataCriacao,endereço.

### 📋 **Listagem de Entregadores**
- **Método**: GET
- **Endpoint**: `/entregas`
- **Descrição**: Retorna todos os pedidos cadastrados.


## 8. Collection do Postman

Para facilitar os testes de API, incluímos uma collection do Postman que pode ser importada diretamente.

### **Importar a Collection**

1. No Postman, clique em **Importar**.
2. Selecione o arquivo [`ms-logistica-entrega-collection.json`](ms-logistica-entrega-collection.json) localizado na raiz do projeto.
3. Acesse e teste todos os endpoints de forma organizada.

### **Executar Requests na Collection**

A collection inclui todos os endpoints com exemplos de requisições:
- Cadastro de entregador
- Atualização de entregador
- Rastreamento de entregas
- Atualização de status
- Listagem de entregadores