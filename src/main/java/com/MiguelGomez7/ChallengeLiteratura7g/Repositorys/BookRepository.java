package com.MiguelGomez7.ChallengeLiteratura7g.Repositorys;


import com.MiguelGomez7.ChallengeLiteratura7g.Models.DigitalBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<DigitalBook,Long> {
    Optional<DigitalBook> findByTituloContainsIgnoreCase(String titulo);

    @Query("SELECT b FROM DigitalBook b WHERE b.idioma = :lan")
    List<DigitalBook> filterDigitalBooksByIdioma(String lan);

    @Query(value = "SELECT * FROM ibook ORDER BY descargas DESC LIMIT 5", nativeQuery= true)
    List<DigitalBook> filterDigitalBooksByDescargas();
}