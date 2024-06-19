package com.MiguelGomez7.ChallengeLiteratura7g.Repositorys;



import com.MiguelGomez7.ChallengeLiteratura7g.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNombreContainsIgnoreCase(String nombre);

    @Query("SELECT a FROM Author a WHERE a.natalicio <= :year AND a.defuncion >= :year")
    List<Author> filterAuthorByYear(int year);
}