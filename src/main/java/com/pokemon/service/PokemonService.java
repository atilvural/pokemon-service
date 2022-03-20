package com.pokemon.service;

import com.pokemon.entity.PokemonEntity;
import com.pokemon.model.GetAllPokemonsResponse;
import org.springframework.data.domain.Page;

public interface PokemonService {
    String fetchAllPokemons();
    GetAllPokemonsResponse getAllPokemons(Integer page, Integer pageSize);
}
