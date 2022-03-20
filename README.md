# pokemon-service
After running this service http://localhost:8081/swagger-ui/#, you can checkout available endpoints for service. 

Calling http://localhost:8081/fetch will fetch pokemons from PokeApi.

Under application.yml, you can find 
pokeApi:
  fetchCount: 500 -> Fetched pokemon count
  pageSize: 10 -> Default pagesize for selecting pokemons
  url: https://pokeapi.co/api/v2 -> pokeApi url
  
# docker
If you take build from docker using
docker build -t pokemon-service:latest .

and call fetch api,
You can check logs using docker logs command
