# Microsserviço de Cardápio - Projeto Java Spring Boot com MySQL + Docker Compose

Este projeto é um microsserviço responsável pela gestão de cardápio (itens de cardápioo e tags ) em um sistema de restaurantes. Nesta fase ele opera de forma independente, mas compartilha o mesmo banco de dados MySQL utilizado pelo microsserviço MS-LOGIN e MS-USUARIO, facilitando a integração futura entre os serviços.

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL (compartilhado via rede Docker)
- Docker & Docker Compose
- Lombok
- OpenAPI/Swagger
- Spring Data JPA

## 📁 Estrutura do Projeto

- `app`: aplicação Spring Boot
- `Dockerfile`: imagem da aplicação
- `wait-for-it.sh`: script que aguarda o banco de dados estar pronto antes de subir a aplicação
- `entrypoint.sh`: ponto de entrada para inicialização segura da aplicação

---

## ⚙️ Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:


- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## 📦 Principais arquivos

| Arquivo              | Descrição                                                                |
|----------------------|--------------------------------------------------------------------------|
| `Dockerfile`         | Define a imagem da aplicação Spring Boot                                 |
| `wait-for-it.sh`     | Script que aguarda o MySQL estar disponível antes de iniciar a aplicação |
| `application.yml`    | Configurações do Spring Boot, incluindo porta e datasource               |
| `entrypoint.sh`      | Script de entrada que executa o JAR da aplicação                         |
| `pom.xml`            | Gerenciador de dependências Maven                                        |

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/PosTech-Fiap-Arq-e-Dev-Java/ms-cardapio
cd ms-cardapio

```
### 2. Compile a aplicação com o Maven

```bash
./mvnw clean package

```
### 3. Dê permissão de execução ao script de espera

```bash
chmod +x wait-for-it.sh
chmod +x entrypoint.sh

```
### 4. Faça o clone do docker-compose 

### 5. Suba o docker-compose contendo as três aplicações e o banco de dados 

```bash
docker-compose up -d

````

## 🔗 Endpoints Disponíveis

| Método   | Caminho                                           | Descrição                                               |
|----------|---------------------------------------------------|---------------------------------------------------------|
| `POST`   | `/itens`                                          | Criar um novo item de cardápio para um usuário          |
| `GET`    | `/itens/{usuario}?idItemCardapio=xxx`             | Consultar cardadápio por item específico de um usuário  |
| `GET`    | `/itens/{usuario}`                                | Consultar itens de cardápio para usuário específico     |
| `PUT`    | `/itens/{usuario}?idItemCardapio=xxx`             | Atualizar itens de cardapio de um usuário específico    |
| `DELETE` | `/itens/{usuario}&idItemCardapio=xx`              | Deletar item específico de um usuário                   |
| `DELETE` | `/itens/{usuario}&idItemCardapio=xx&codigoTag=xx` | Deletar tags de um item especícifo                      |
| `POST`   | `/itens/{usuario}/tags&idItemCardapio=xx`         | Cria uma nova tag para um item específico de um usuário |


## 🚀 Documentação API (Swagger)

Para explorar e testar os endpoints do microsserviço de forma visual, acesse a documentação interativa Swagger no link abaixo:

[🌐 Acesse a documentação Swagger](http://localhost:9909/ms-cardapio/swagger-ui/index.html)


---

## 🛢️ Conexão com Banco de Dados MySQL


| Configuração | Valor                                                            |
|--------------|------------------------------------------------------------------|
| **Host**     | `container-mysql` (nome do container MySQL criado pelo ms-login) |
| **Porta**    | `3306`                                                           |
| **Usuário**  | `adm123`                                                         |
| **Senha**    | `adm123`                                                         |
| **Database** | `db-tc-grupo8`                                                   |


## 🗄️ Tabelas manipuladas pelo ms-cardapio
O microsserviço ms-cardapio interage com as seguintes tabelas no banco de dados MySQL compartilhado:

| Tabela                 | Operações realizadas                   | Descrição                                             |
|------------------------|----------------------------------------|-------------------------------------------------------|
| `tb_tag_cardapio`      | `SELECT`                               | Armazena as tags de cardápio                          |
| `tb_item_cardapio`     | `SELECT`, `INSERT`, `UPDATE`, `DELETE` | Armmazena os items de cardápio.                       |
| `tb_item_tag_cardapio` | `SELECT`, `INSERT`, `UPDATE`, `DELETE` | Armmazena as tags relacionadas aos itens de cardápios |

---

## ‍💻 Autores

Este projeto faz parte da Pós-graduação em Arquitetura e Desenvolvimento Java da FIAP e implementa um microsserviço de gestão de cadastros com documentação OpenAPI e persistência de dados em MySQL, seguindo boas práticas de microsserviços.

- Raysse Geise Alves Cutrim - rayssecutrim@hotmail.com

