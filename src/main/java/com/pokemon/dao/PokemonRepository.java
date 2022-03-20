package com.pokemon.dao;

import com.pokemon.entity.PokemonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends PagingAndSortingRepository<PokemonEntity, Integer> {
}
