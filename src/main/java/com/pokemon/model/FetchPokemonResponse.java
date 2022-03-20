package com.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class FetchPokemonResponse {
    private BigDecimal height;
    private BigDecimal weight;
    private String name;
    private List<Types> types;
    private List<Moves> moves;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Moves {
        private Move move;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Move {
            private String name;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Types {
        private Type type;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Type {
            private String name;
        }
    }
}
