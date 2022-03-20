package com.pokemon.feign;

import com.pokemon.model.FetchPokemonResponse;
import com.pokemon.model.ListPokemonsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pokeApi", url = "${pokeApi.url}")
public interface PokeApi {

    @RequestMapping(method = RequestMethod.GET,
            value = "/pokemon/?limit={limit}&offset={offset}"
    )
    ListPokemonsResponse listPokemons(@PathVariable Integer offset,
                        @PathVariable Integer limit,
                        @RequestHeader("User-Agent") String uAgent
    );

    @RequestMapping(method = RequestMethod.GET,
            value = "/pokemon/{id}/"
    )
    FetchPokemonResponse fetchPokemonById(@PathVariable String id,
                                      @RequestHeader("User-Agent") String uAgent
    );
}
