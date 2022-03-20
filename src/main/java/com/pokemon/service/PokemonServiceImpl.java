package com.pokemon.service;

import com.pokemon.dao.PokemonRepository;
import com.pokemon.entity.PokemonEntity;
import com.pokemon.model.GetAllPokemonsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService{
    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokeApiService pokeApiService;

    private static final Integer INCREMENTAL = 100;

    @Value("${pokeApi.pageSize}")
    private Integer pageSize;

    @Transactional
    public String fetchAllPokemons() {
        pokeApiService.fetchPokemons();
        return "fetchAllPokemons started";
    }

    public GetAllPokemonsResponse getAllPokemons(Integer page, Integer pageSize) {
        Page<PokemonEntity> result = pokemonRepository.findAll(PageRequest.of(
                page < 1 ? 1 : page - 1,
                pageSize < 1 ? INCREMENTAL : pageSize)
        );
        return GetAllPokemonsResponse.builder()
                .curPage(page)
                .totalPage(result.getTotalPages())
                .pokemons(result.getContent())
                .build();
    }
}
