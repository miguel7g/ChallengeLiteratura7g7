package com.MiguelGomez7.ChallengeLiteratura7g.Models;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorInfoRecord(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer natalicio,
        @JsonAlias("death_year") Integer defuncion
) {
}
