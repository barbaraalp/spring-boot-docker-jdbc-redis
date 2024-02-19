# Spring Boot Docker JDBC Redis

Projeto **Spring Boot Docker JDBC Redis**! 🌟
Este projeto demonstra como criar uma aplicação Java Spring Boot que interage com um banco de dados PostgreSQL usando JDBC e utiliza o Redis para caching.

### Sumário
1. [Tecnologias](#tecnologias)
2. [Pré-requisitos](#pré-requisitos)
3. [Instruções de Compilação](#instruções-de-compilação)
4. [Estrutura do Projeto](#estrutura-do-projeto)

### Tecnologias:

- Spring Boot: Framework Java para desenvolvimento rápido e robusto de aplicações web.
- Postgres: Banco de dados relacional confiável e escalável.
- Redis: Sistema de cache de memória in-memory de alta performance.
- Docker: Ferramenta para containerização e orquestração de aplicações.

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte item instalado em sua máquina:
- [Docker](https://www.docker.com/get-started)

## Instruções de Compilação

Para compilar e executar o projeto, siga estes passos:

1. Clone este repositório em sua máquina local.

2. Abra um terminal ou prompt de comando e navegue até o diretório do projeto.

3. Use o Docker Compose para iniciar o banco de dados PostgreSQL, o cache Redis e a aplicação Java Spring Boot:

```sh
docker-compose up -d
```

4. Para verificar se o caching está funcionando corretamente, verifique os logs do contêiner da aplicação Java:

```sh
docker logs javadev
```

6. Acessar a aplicação:

- Para recuperar todas as listagens de alimentos: `GET  http://localhost:8080/food-listings`
- Para recuperar uma listagem de alimentos específica por ID: `GET  http://localhost:8080/food-listings/{id}`

## Estrutura do Projeto

- **Dockerfile**: Define a configuração da imagem Docker para a aplicação Java Spring Boot.
- **docker-compose.yml**: Define os serviços e suas configurações usando o Docker Compose.
- **pom.xml**: Arquivo de configuração do Maven especificando dependências do projeto e configurações de compilação.
- **src/main/java/com/example/myspringbootapp**: Diretório de código-fonte Java.
- **config/RedisCacheConfig.java**: Classe de configuração para o caching do Redis.
- **controller/FoodListingController.java**: Controlador REST que manipula endpoints de listagem de alimentos.
- **model/FoodListing.java**: Classe de entidade que representa uma listagem de alimentos.
- **repository/FoodListingRepository.java**: Interface de repositório para operações CRUD em listagens de alimentos.
- **service/FoodListingService.java**: Classe de serviço que implementa a lógica de negócios para listagens de alimentos.
- **DemoApplication.java**: Classe principal da aplicação Spring Boot.
- **src/main/resources/application.properties**: Arquivo de configuração da aplicação, incluindo configurações do banco de dados e do Redis.

🚀
