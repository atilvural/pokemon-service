package com.pokemon.controller;

import com.pokemon.entity.PokemonEntity;
import com.pokemon.model.GetAllPokemonsResponse;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/fetch")
    public String fetch(){
        return pokemonService.fetchAllPokemons();
    }

    @GetMapping("/pokemons")
    public ResponseEntity<GetAllPokemonsResponse> getAllPokemons(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize
    ){
        return ResponseEntity.ok(pokemonService.getAllPokemons(page ,pageSize));
    }
}
