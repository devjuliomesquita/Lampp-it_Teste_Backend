# Lampp-it Teste Backend JAVA
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devjuliomesquita/Lampp-it_Teste_Backend/blob/main/LICENSE) 

# Sobre o projeto
Este repositório contém um desafio, foi construido um simples CRUD de uma entidade funcionário. É possível criar, atualizar deletar e retornar funcionários. Aplicação é do tipo API Rest contruida com Java Spring .


## Tabela de conteúdo

- [Instalação](#instalação)
- [Configuração](#uso)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Documentação](#documentação)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/devjuliomesquita/Lampp-it_Teste_Backend.git
```

2. Instale as dependências usando o Meaven

## Uso

1. Inicie a aplicação usando o Maven
2. A API é acessada pela url http://localhost:8080/swagger-ui/index.html


## API Endpoints
A API fornece os seguintes ENDPOINTS:

#### Controller Funcionário
```markdown
GET / - Retorna uma lista de funcionários | Utilizado paginação para retornar a quantidade e ordenação desejada.

GET / - Retorna uma lista de funcionários ordenado pelo nome.

GET / - Retorna um funcionário que foi buscado pelo id. 

POST / - Criando um novo funcionário.

PUT / - Atualizando um funcionário pelo id.

DELETE / - Excluindo um funcionário pelo id.
```
#### Controller Testte de Array
```markdown
POST / - Retona true ou false após a verificação de um Array de string.
```

## Database
O projeto utiliza PostgresSQL como banco de dados.

Para [install PostgresSQL](https://www.postgresql.org/download/) você pode instalar aqui.

## Documentação
O projeto foi testado e documentado via Thunder Client e Swagger.

<div style="display: inline_block" align="center">
  <img width=49% src="https://github.com/devjuliomesquita/Lampp-it_Teste_Backend/blob/main/acetss/swagger1.png"/>
  <img width=49% src="https://github.com/devjuliomesquita/Lampp-it_Teste_Backend/blob/main/acetss/swagger2.png"/>
</div>
