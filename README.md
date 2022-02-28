# airport-manager
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jonassantos1000/Conatus-SpringBoot-Java-8-PostGree/blob/main/LICENSE) 

# Sobre o Projeto

Sistema que realiza o gerenciamento de aeroportos, desenvolvido com a tecnologia SpringBoot e integrado com o banco de dados MYSQL.

# Como utilizar a API 

É possivel testar online os endpoints da API através do Heroku, pelo link a seguir: 

Endpoints diponiveis para serem testados:
- client
- flight
- ticket

Exemplos de utilização de cada endpoint:

## Client

  Post:
	
    Url Requisição: 
		
    Exemplo Json:
		
    {
    "nome": "Post sucess"
    }
    
  Get:
   ```
     Find All:

      Url Requisição:

      Ex: 
		
   ```
   
## Flight

  Post:
	
    Url Requisição:
		
    Exemplo Json:
		
    {
        "horario_saida": "2022-02-28 16:20:00",
        "horario_chegada": "2022-02-29 17:20:00",
        "qtde_assento_total": 10,
        "preço_passagem": 200.0,
        "origem": "congonhas",
        "destino": "guarulhos"
    }
    
  Get:
   ```
     Find All:

      Url Requisição:

      Ex: 
		
   ```
   
   # Tecnologias utilizadas
   
   ## Back end
   
   - Java
   - Spring boot
   - JPA / Hibernate
   - Maven

   ## Implantação em Produção
   
   - Back end: Heroku
   - Banco de dados: PostgreSQL
   
   # Autor 
     
     Jonas Santos do Vale Silva
     
     https://www.linkedin.com/in/jonas-santos-15a64a179
  
