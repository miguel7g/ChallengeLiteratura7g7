package com.MiguelGomez7.ChallengeLiteratura7g.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ibook")
public class DigitalBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private Double descargas;
    @ManyToOne
    private Author author;

    public DigitalBook() {}

    public DigitalBook(DigitalBookRecordData bookData, List<Author> authorList) {
        this.titulo = bookData.titulo();
        this.idioma = bookData.idioma().get(0);
        this.author = authorList.get(0);
        this.descargas = Double.valueOf(bookData.descargas());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String lidioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
       String nombreAutor= (author != null) ? author.getNombre() : """
                                                                 ======================================
                                                                   [⛔ NO SE RECONOCE ESTE AUT@R 👨‍💼👩‍💼]
                                                                 ======================================

                                                                 """;
        String message = String.format("**************** [📕 Libro 📗] *********\n"
                        + "Titulo: %s\nAutor: %s\nIdioma: %s\nDescargas: %s\n"+
                 "==============================================================================================================================================\n",
                 "[🎇" +titulo +"🎇]","[👩‍💼"+ nombreAutor +"👨‍💼]","[📣"+ idioma+"📣]","[⬇"+ descargas+"⬇]");
        return message;
   }

}
