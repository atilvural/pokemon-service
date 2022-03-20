package com.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListPokemonsResponse {
    private String next;
    private List<PokemonResult> results;

    @Data
    @AllArgsConstructor
    public static class PokemonResult{
        private String name;
        private String url;
    }
}


