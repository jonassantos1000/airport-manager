# airport-manager
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jonassantos1000/Conatus-SpringBoot-Java-8-PostGree/blob/main/LICENSE) 

# Sobre o Projeto

Sistema que realiza vendas de passagem aérea, desenvolvido com a tecnologia SpringBoot e integrado com o banco de dados MYSQL.

# Pré-requisitos

- Banco de dados Mysql, disponível no link: https://dev.mysql.com/downloads/file/?id=510039
- Java SE Development Kit 17.0.2, disponível no link: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Configurar variáveis de ambiente do Java.

# Como rodar API 

1º Execute o script airport.sql via workbeanch, esse script é responsável por criar as tabelas necessárias para o funcionamento do sistema.

2º Clone o projeto, digitando o seguinte comando no terminal: git clone https://github.com/jonassantos1000/airport-manager.git

3º Entre no diretório do projeto pelo terminal e rode o comando: mvnw clean package

4º Copie o arquivo datasource.ini para a pasta target

5º Abra o arquivo datasource.ini, na segunda linha informe o usuario do banco, e na terceira linha informe a senha do banco. Salve o arquivo.

6º Pelo terminal, execute o seguinte comando: java -jar target/aiport.jar

# Endpoints da API 

É possível testar os retornos da API através dos endpoints a seguir: 

Endpoints diponíveis para serem testados:
- client
- flight
- ticket

Exemplos de utilização de cada endpoint:

## Client

Para incluir um novo cliente, utilizar a requisição abaixo:

  Post:
	
    Url Requisição: localhost:8080/clients
		
    Exemplo Json:
		
    {
    "name": "Client default"
    }
    
  Para pesquisar a lista de clientes, utilizar a requisição abaixo:
  
  Get:
   ```
     Find All:

      Url Requisição: localhost:8080/clients
		
   ```
   
## Flight

Para incluir um novo voo, utilizar a requisição abaixo:

  Post:
	
    Url Requisição: localhost:8080/flight
		
    Exemplo Json:
		
    {
        "horario_saida": "2022-02-28 16:20:00",
        "horario_chegada": "2022-02-29 19:20:00",
        "qtde_assento_total": 2,
        "preço_passagem": 500.0,
        "origem": "salvador",
        "destino": "guarulhos"
    }

Para pesquisar a lista de voos, utilizar a requisição abaixo:

Get:
    
   ```
     
   Find All:

   Url Requisição: localhost:8080/flight
       
   ```
    
## Ticket

Para incluir a compra da passagem aérea, utilizar a requisição abaixo:

  Post:
	
    Url Requisição: localhost:8080/ticket
		
    Exemplo Json:
		
    {
        "assento": 1,
        "flight": {
            "id": 1
        },
        "client": {
            "id": 1
        },
        "data_compra": "2022-02-26 21:00:00"
    }
    
  Para pesquisar a lista de passagens aéreas, utilizar a requisição abaixo:  
    
  Get:
   ```
     Find All:

      Url Requisição: localhost:8080/ticket
		
   ```
   
   # Tecnologias utilizadas
   
   ## Back end
   
   - Java
   - Spring boot
   - JPA / Hibernate
   - Maven

   ## Implantação em Produção
   
   - Banco de dados: MySQL
   
   # Autor 
     
     Jonas Santos do Vale Silva
     
     https://www.linkedin.com/in/jonas-santos-15a64a179
  
