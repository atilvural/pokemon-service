# pokemon-service
After running this service http://localhost:8081/swagger-ui/#, you can checkout available endpoints for service. <br />

Calling http://localhost:8081/fetch will fetch pokemons from PokeApi.<br />

Under application.yml, you can find <br />
pokeApi:<br />
  fetchCount: 500 -> Fetched pokemon count<br />
  pageSize: 10 -> Default pagesize for selecting pokemons<br />
  url: https://pokeapi.co/api/v2 -> pokeApi url<br />
  
# docker
If you take build from docker using<br />
docker build -t pokemon-service:latest .<br />

and call fetch api,<br />
You can check logs using docker logs command
