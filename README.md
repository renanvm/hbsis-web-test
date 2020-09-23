# Weather Forecast App

Aplicação monolítica que permite cadastrar cidades e exibir previsões do tempo das mesmas.

  - Backend construído em Java (Spring Boot)
  - Frontend construído com Angular e Bootstrap
  - Banco de dados H2
  - Deploy com Docker
  - Integração com OpenWeatherMap API
 
#### Como rodar a aplicação?
  - Para rodar a aplicação é necessário ter duas ferramentas: **Docker** e **Docker Compose**
  - Dentro da pasta do projeto execute o seguinte comando: ``` docker-compose up ```
  - Os containers **weatherforecast-app** e **weatherforecast-ui** serão inicializados
  - Comando para parar a aplicação ```docker-compose down```

#### Como acessar a aplicação?
 -  Aplicação pode ser acessada no seguinte endereço: **http://localhost:4200**
