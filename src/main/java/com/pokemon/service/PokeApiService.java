package com.pokemon.service;

import com.pokemon.dao.PokemonRepository;
import com.pokemon.entity.PokemonEntity;
import com.pokemon.feign.PokeApi;
import com.pokemon.model.FetchPokemonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class PokeApiService {
    @Autowired
    private PokeApi pokeApi;
    @Autowired
    private PokemonRepository pokemonRepository;

    @Value("${pokeApi.fetchCount}")
    private int fetchLimit;

    private static final String USER_AGENT = "cheese";

    @Async
    public void fetchPokemons() {
        pokemonRepository.deleteAll();

        pokemonRepository.saveAll(
            IntStream.range(1, fetchLimit + 1)
                    .boxed()
                    .parallel()
                    .map(index -> fetchPokemonById(index.toString()))
                    .collect(Collectors.toList())
        );

        log.info("fetchPokemons is finished");
    }

    @Async
    public PokemonEntity fetchPokemonById(String id){
        log.info("fetchPokemonById id: {}", id);
        FetchPokemonResponse response = pokeApi.fetchPokemonById(id, USER_AGENT);
        return PokemonEntity.builder()
                .name(StringUtils.capitalize(response.getName()))
                .weight(response.getWeight()
                        .multiply(new BigDecimal(0.1))
                        .setScale(3, RoundingMode.HALF_UP)
                        .doubleValue())
                .height(response.getHeight()
                        .multiply(new BigDecimal(0.1))
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue())
                .moves(
                        response.getMoves().stream()
                                .limit(4)
                                .map(moves -> StringUtils.capitalize(moves.getMove().getName()))
                                .collect(Collectors.joining(","))
                )
                .types(
                        response.getTypes().stream()
                                .map(moves -> StringUtils.capitalize(moves.getType().getName()))
                                .collect(Collectors.joining(","))
                )
                .build();
    }
}
