package com.MiguelGomez7.ChallengeLiteratura7g.Models;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DigitalBookRecordData(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AuthorInfoRecord> autor ,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer descargas
) {
}
