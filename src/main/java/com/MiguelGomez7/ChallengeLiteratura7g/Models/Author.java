package com.MiguelGomez7.ChallengeLiteratura7g.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer natalicio;
    private Integer defuncion;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DigitalBook> DBooks;

    public Author() {}
    public Author(AuthorInfoRecord authorData) {
        this.nombre = authorData.nombre();
        this.natalicio = authorData.natalicio();
        this.defuncion = authorData.defuncion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNatalicio() {
        return natalicio;
    }

    public void setNatalicio(Integer natalicio) {
        this.natalicio = natalicio;
    }

    public Integer getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(Integer defuncion) {
        this.defuncion = defuncion;
    }

    public List<DigitalBook> getDBooks() {
        return DBooks;
    }

    public void setDbooks(List<DigitalBook> DBooks) {
        this.DBooks = DBooks;
    }

    @Override
    public String toString() {
        List<String> authorDBooks = DBooks.stream()
                .map(b -> b.getTitulo())
                .collect(Collectors.toList());

        String message = String.format("  🎇Nombre: %s\n 👶fechaDeNacimineto: %s\n 👻fechaDeMuerte: %s" ,
                " **["+ nombre + "]**🎇"," **["+ natalicio+ "]**👶", "**["+ defuncion+ "]**👻");
        System.out.println( "==============================================================================================================================================\n");

        return message;
    }

}