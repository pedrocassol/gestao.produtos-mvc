# ProductGED Spring MVC

Reimplementacao do sistema web **ProductGED** utilizando Spring Boot e o
padrao MVC.

O projeto foi desenvolvido durante a disciplina de **Programacao Orientada a
Objetos para Web I** com o objetivo de evoluir a versao original, baseada em
Servlets, para uma aplicacao com controllers gerenciados pelo Spring MVC e
servidor embarcado.

## Sobre o projeto

O ProductGED e um sistema simples de gestao de produtos. A aplicacao permite
criar uma conta, autenticar usuarios e realizar as operacoes de cadastro,
consulta, edicao e exclusao de produtos.

Esta versao mantem a separacao em camadas da aplicacao original:

- **Controller:** recebe as requisicoes HTTP e controla a navegacao;
- **Service:** organiza as operacoes da aplicacao;
- **DAO:** executa o acesso ao PostgreSQL com JDBC;
- **Model:** representa usuarios e produtos;
- **View:** apresenta as paginas JSP estilizadas com CSS.

## Funcionalidades

- Cadastro de usuarios;
- Login e logout com sessao;
- Controle de acesso a pagina de produtos;
- Cadastro de produtos;
- Listagem de produtos;
- Edicao de produtos;
- Exclusao de produtos;
- Persistencia em PostgreSQL.

## Tecnologias

- Java 21;
- Spring Boot;
- Spring MVC;
- JSP e JSTL;
- JDBC;
- PostgreSQL;
- Maven;
- HTML e CSS.

## Evolucao da versao anterior

Este projeto e uma nova implementacao do
[ProductGED Web](https://github.com/pedrocassol/productged-web).

| Versao original | Nova versao |
| --- | --- |
| Controllers implementados com Servlets | Controllers com anotacoes do Spring MVC |
| Configuracao e implantacao manual no Tomcat | Execucao com Spring Boot e servidor embarcado |
| Mapeamento com `HttpServlet` | Rotas com `@GetMapping` e `@PostMapping` |
| Projeto empacotado como WAR | Aplicacao iniciada pela classe `DemoApplication` |

As duas versoes utilizam JSP, JDBC, PostgreSQL e uma arquitetura organizada em
camadas.

## Estrutura

```text
src
+-- main
|   +-- java/gestao/produtos_mvc/demo
|   |   +-- controller
|   |   +-- dao
|   |   +-- model
|   |   +-- service
|   |   +-- DemoApplication.java
|   +-- resources
|   |   +-- application.properties
|   +-- webapp
|       +-- css
|       +-- images
|       +-- WEB-INF/pages
+-- test
```

## Banco de dados

Crie um banco PostgreSQL chamado `gestao-produtos-mvc`:

```sql
CREATE DATABASE "gestao-produtos-mvc";
```

Conecte-se ao banco e crie as tabelas:

```sql
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco NUMERIC(10, 2) NOT NULL,
    quantidade INTEGER NOT NULL
);
```

Os dados de conexao estao definidos em:

```text
src/main/java/gestao/produtos_mvc/demo/dao/ConexaoDB.java
```

Antes de executar, confira a URL, o usuario e a senha de acordo com a
configuracao do PostgreSQL na sua maquina.

## Como executar

### Pre-requisitos

- JDK 21;
- PostgreSQL;
- Git.

### Passos

1. Clone o repositorio:

```bash
git clone https://github.com/pedrocassol/productged-spring-mvc.git
```

2. Entre na pasta:

```bash
cd productged-spring-mvc
```

3. Configure e inicialize o banco conforme a secao anterior.

4. Execute a aplicacao:

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

5. Acesse no navegador:

```text
http://localhost:9090/login
```

## Contexto academico

Projeto desenvolvido para fins de estudo e pratica de Java Web, Spring MVC,
arquitetura em camadas, sessoes HTTP e persistencia de dados com JDBC.
