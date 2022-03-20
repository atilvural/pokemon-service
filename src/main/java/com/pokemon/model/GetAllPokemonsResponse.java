package com.pokemon.model;

import com.pokemon.entity.PokemonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPokemonsResponse {
    private int totalPage;
    private int curPage;
    private List<PokemonEntity> pokemons;
}
