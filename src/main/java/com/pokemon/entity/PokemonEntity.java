package com.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "pokemons")
@DynamicUpdate
@DynamicInsert
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokemonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "moves")
    private String moves;

    @Column(name = "types")
    private String types;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;
}
