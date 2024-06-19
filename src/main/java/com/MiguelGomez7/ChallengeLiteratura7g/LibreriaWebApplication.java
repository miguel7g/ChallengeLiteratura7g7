package com.MiguelGomez7.ChallengeLiteratura7g;


import com.MiguelGomez7.ChallengeLiteratura7g.Principal.Principal;
import com.MiguelGomez7.ChallengeLiteratura7g.Repositorys.AuthorRepository;
import com.MiguelGomez7.ChallengeLiteratura7g.Repositorys.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaWebApplication implements CommandLineRunner{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibreriaWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal main = new Principal(bookRepository,authorRepository);
        main.muestarMenu();
    }
}

