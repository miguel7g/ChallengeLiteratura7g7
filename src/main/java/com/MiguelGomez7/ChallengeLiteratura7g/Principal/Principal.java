package com.MiguelGomez7.ChallengeLiteratura7g.Principal;



import com.MiguelGomez7.ChallengeLiteratura7g.Models.Author;
import com.MiguelGomez7.ChallengeLiteratura7g.Models.DigitalBook;
import com.MiguelGomez7.ChallengeLiteratura7g.Models.DigitalBookRecordData;
import com.MiguelGomez7.ChallengeLiteratura7g.Models.DatosBusqueda;
import com.MiguelGomez7.ChallengeLiteratura7g.Repositorys.AuthorRepository;
import com.MiguelGomez7.ChallengeLiteratura7g.Repositorys.BookRepository;
import com.MiguelGomez7.ChallengeLiteratura7g.Services.ConsumeAPI;
import com.MiguelGomez7.ChallengeLiteratura7g.Services.Conversor;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_SEARCH_BY_NAME = "?search=";
    private final Scanner SCANNER = new Scanner(System.in);
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private Conversor conversor = new Conversor();
    private ConsumeAPI consumeAPI = new ConsumeAPI();

    public Principal(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void muestarMenu() {
        var opciones = "-1";
        while (opciones!="0") {
            String MENU = """
                                       ******************************************************************************************************************************
                                       ==============================================================================================================================
                                                             ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******
                                                                   *******[📚] BIENVENID@S-BIENVENID@S-BIENVENID@S-BIENVENID@S [📚] *******
                                
                                
                                                                             ««««««««««««««««««««««««««««»»»»»»»»»»»»»»»»»»»»»»»»»»»
                                                                             »    Opcion N°1→ BUSCAR LIBRO POR TITULO         📚   «
                                                                             »    Opcion N°2→ MOSRAR LIBROS GUARDADOS         📚   «                                                               
                                                                             »    Opcion N°3→ BUSCAR  AUTORES REGISTRADOS     📚   «
                                                                             »    Opcion N°4→ BUSCAR  AUTORES POR NOMBRE      📚   «
                                                                             »    Opcion N°5→ STATUS DE VIDA DE AUTORES       📚   «
                                                                             »    Opcion N°6→ MOSTRAR LIBROS POR IDIOMA       📚   «
                                                                             »    Opcion N°7→ LIBROS MAS Y MENOS  DESCARGADOS 📚   «
                                                                             »    Opcion N°8→ TOP 15 DESCARGAS GUTENDEXAPI    📚   «
                                                                             »    Opcion N°9→ TOP 5 EN LITERARIOS L@ CHIVA7🐐 📚   «                                                              
                                                                             »                                                     «
                                                                             »    Opcion N°0→ Salir 💨                             «
                                                                             ««««««««««««««««««««««««««««»»»»»»»»»»»»»»»»»»»»»»»»»»»
                                
                    
                                        ==============================================================================================================================
                                        ******************************************************************************************************************************
                                        """;
            System.out.println(MENU);
            System.out.println("                                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("                                              *** 🐐 INGRESE LA OPCION DE SU PREFERENCIA 🐐  ***");
            System.out.println("====================================================================================================================================================================");

            //VAMOS A IMPLEMENTAR UNA COMUNICACION CON EL USER ATRAVEZ DE CONSOLA
            opciones = SCANNER.nextLine();
            switch (opciones) {
                case "1":
                    buscarLibrosXTitulos();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    mostrarLibrosGuardados();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                    break;
                case "3":
                    mostraAutoresRegistrados();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    BuscarAutoresPorNombre();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    StatusDeVidaDeAutores();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "6":
                    mostrarLibrosPorIdiomas();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "7":
                    recordsDeLibros();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    top15GutendexAPI();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "9":
                    top5ChivaDB();
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "0":
                    opciones = "0";
                    System.out.println("=================================================================================================================\n");
                    System.out.println("          ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                    System.out.println("                               *******GRACIAS POR PREFERIRNOS********                    ");
                    System.out.println("                                     *******[ SALIENDO💨 ] *******                       \n");
                    System.out.println("=================================================================================================================\n");
                    try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("=================================================================================================================\n");
                    System.out.println("        ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                    System.out.println("                      *******Lo sentimos su opción es: [ INVALIDA ] *******              ");
                    System.out.println("                *******Por favor, elija una opción: [ CORRECTA ] de nuestro menú 👆 *******\n");
                    System.out.println("=================================================================================================================\n");try {
                        // Hacer que el hilo actual duerma durante 5000 milisegundos (5 segundo)
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public List<DigitalBookRecordData> obtenerLibrosMasPopulares() {
        String json = consumeAPI.getData(URL_BASE + "?sort=popular");
        List<DigitalBookRecordData> Libros = conversor.convertData(json, DatosBusqueda.class).results();

        return Libros;
    }

    public Optional<DigitalBookRecordData> mostrarLibrosTopChivaDB(String userTitle) {
        String json = consumeAPI.getData(URL_BASE + URL_SEARCH_BY_NAME + userTitle.toLowerCase().replace(" ", "+"));
        List<DigitalBookRecordData> books = conversor.convertData(json, DatosBusqueda.class).results();

        Optional<DigitalBookRecordData> book = books.stream()
                .filter(l -> l.titulo().toLowerCase().contains(userTitle.toLowerCase()))
                .findFirst();

        return book;
    }

    public void buscarLibrosXTitulos() {
        System.out.println("==============================================================================================================================");
        System.out.println("                    ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                              *** [📘] INGRESE EL NOMBRE DEL LIBRO QUE DESEA BUSACAR   [📒] ***");
        System.out.println("==============================================================================================================================");
        String tituloLibro = SCANNER.nextLine();
        Optional<DigitalBookRecordData> gutendexAPILibro = mostrarLibrosTopChivaDB(tituloLibro);
        //asi se evita que se repitan libros en la base de datos la chiva
        Optional<DigitalBook> chivaDBlLibro= bookRepository.findByTituloContainsIgnoreCase(tituloLibro);
        if (chivaDBlLibro.isPresent()) {
            System.out.println("======================================================================================================================================================================================================================================");
                System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                System.out.println("                                        *** [📘] DATOS DEL LIBRO  [📒] ***");
                System.out.println(" Este libro[📘]" + tituloLibro+ "[📘] ya fue registrado anteriormente, seleccione Opcion N°2→ MOSRAR LIBROS GUARDADOS 📚, para acceder a la informacion del libro [📗 "  + tituloLibro+ " 📕], o introdusca un nuevo titulo");
                System.out.println("================================================================================================================================================================================================================================\n");
            // si encontramos el libro en la api...
        } else if (gutendexAPILibro.isPresent()) {

            // busca y crea nuevo autor
            List<Author> authorList = gutendexAPILibro.get().autor().stream()
                    .map(a -> authorRepository.findByNombreContainsIgnoreCase(a.nombre())
                            .orElseGet(() -> authorRepository.save(new Author(a))))
                    .collect(Collectors.toList());

            // nueva instancia...
            DigitalBook newDbBook = new DigitalBook(gutendexAPILibro.get(),authorList);
            bookRepository.save(newDbBook);
            System.out.println("==============================================================================================================================");
            System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("                                        *** [📘] DATOS DEL LIBRO  [📒] ***\n");
            System.out.println(newDbBook);
            System.out.println("==============================================================================================================================\n");

        } else {
            System.out.println("==================================================================================================================================");
                    System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                    System.out.println("                      *******Lo sentimos el nombre del libro no existe en: [GUTENDEX API] *******              ");
                    System.out.println("                                   *** [📗] INGRESE EL LIBRO QUE DESEA BUSACAR  [📙] ***");
                    System.out.println("==================================================================================================================================\n");
            muestarMenu();
        }
    }

    public void  mostrarLibrosGuardados() {
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                                 *** [📘] DATOS DEL LIBROS GUARDADOS  [📒] ***");
        System.out.println("===============================================================================================================================================================================================================");
        List<DigitalBook> chivaDBLibroG = bookRepository.findAll();
        chivaDBLibroG.forEach(s-> System.out.println("📒Libro:  **[" + s.getTitulo()+ "]**📕\n  📣Idioma: **["+ s.getIdioma()+"]**📣\n  ⬇ Numero de Descargas: **[" + s.getDescargas()+ "]**⬇\n 👨‍💼************ Datos de Aut@r ************👩‍💼\n " + s.getAuthor()+ "\n" ));
        System.out.println("===============================================================================================================================================================================================================");
    //  printSizeBr("libros", chivaDBLibroG.size());
    }
    public void  mostraAutoresRegistrados() {
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                                  *** [👩‍💼] DATOS DE AUT@R REGISTRADOS  [👨‍💼] ***");
        System.out.println("===============================================================================================================================================================================================================");
        List<Author> dbAutor = authorRepository.findAll();
        dbAutor.forEach(s-> System.out.println("👨‍💼 Nombre del Aut@r: **["+ s.getNombre()+"]**👩‍💼, 👶Fecha De Nacimiento: **["+ s.getNatalicio()+"]**👶, 👻 Fecha De Muerte: **["+ s.getDefuncion()+"]**👻"));
        System.out.println("===============================================================================================================================================================================================================");
    }
    public void BuscarAutoresPorNombre() {
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                       *** [👩‍💼] INGRESE EL NOMBRE DEL AUT@R QUE DESEA BUSCAR   [👨‍💼] ***");
        System.out.println("===============================================================================================================================================================================================================");
        String authorName = SCANNER.nextLine();
        Optional<Author> chivaDBAuthor = authorRepository.findByNombreContainsIgnoreCase(authorName);

        if ( chivaDBAuthor.isPresent()) {
            System.out.println("==============================================================================================================================");
            System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("                                  *** [👩‍💼] DATOS DE AUT@R POR NOMBRE [👨‍💼] ***");
            System.out.println( chivaDBAuthor.get());
            System.out.println("==============================================================================================================================\n");

        } else {
            System.out.println("==================================================================================================================================");
            System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("                                   *******Lo sentimos el Autor no existe*******              ");
            System.out.println("==================================================================================================================================\n");
            muestarMenu();
        }
    }
    private boolean estaMuerto(Author author) {
        return false;
    }

    public void  StatusDeVidaDeAutores() {
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                       *** [👩‍💼] INGRESE EL AÑO QUE DESEA CONSULTAR SI EL AUT@R VIVIA [👨‍💼] ***");
        System.out.println("===============================================================================================================================================================================================================");
        int fecha = SCANNER.nextInt();
        SCANNER.nextLine();
        List<Author> filteredAuthors = authorRepository.filterAuthorByYear(fecha);

            if (!filteredAuthors.isEmpty()) {
                filteredAuthors.forEach(author -> {
                    boolean estaMuerto = estaMuerto(author);
                    if (estaMuerto) {
                        System.out.println("==============================================================================================================================");
                        System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                        System.out.println("                                   *** [👩‍💼] STATUS DEL AUT@RES VIVIOS  [👨‍💼] ***");
                        System.out.println("          ****[👨‍💼] El aut@r:[" + author.getNombre() + "][👩‍💼] EN PARA ESTA FECHA: ["+ fecha +"] ESTA MUERTO 🎚 *****" );
                        System.out.println("==============================================================================================================================\n");

                    } else {
                        System.out.println("==============================================================================================================================");
                        System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                        System.out.println("                                     *** [👩‍💼] STATUS DEL AUT@RRES VIVIOS  [👨‍💼] ***");
                        System.out.println("          ****[👨‍💼] El aut@r:[" + author.getNombre() + "][👩‍💼] PARA ESTA FECHA: ["+ fecha +"] SIGUE VIVO 🤾‍♂️ *****" );
                        System.out.println("==============================================================================================================================\n");

                    }
                });
            } else {
                System.out.println("==============================================================================================================================");
                System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
                System.out.println("                                        *** [👩‍💼] STATUS DEL AUT@R  [👨‍💼] ***");
                System.out.println("                   ****[👨‍💼] NO SE ENCONTRARON CRITERIOS QUE CUMPLAN CON NINGUN AUT@R[👩‍💼] ️ *****" );
                System.out.println("==============================================================================================================================\n");
            }
        }
    public void mostrarLibrosPorIdiomas() {
        List<String> idiomas = List.of("es", "en", "fr", "pt");
        String menuDeidiomas = """
                                       ******************************************************************************************************************************
                                       ==============================================================================================================================
                                                                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******
                                                                           *******[📚] IDIOMAS-IDIOMAS-IDIOMAS-IDIOMAS [📚] *******                                
                                
                                                                             ««««««««««««««««««««««««««««»»»»»»»»»»»»»»»»»»»»»»»»»»»
                                                                             »           Opcion N°1→ ES = ESPAÑOL   📣             «
                                                                             »           Opcion N°2→ EN = INGLES    📣             «                                                               
                                                                             »           Opcion N°3→ FR = FRANCES   📣             «
                                                                             »           Opcion N°4→ PT = PORTUGUES 📣             «                                                                          
                                                                             ««««««««««««««««««««««««««««»»»»»»»»»»»»»»»»»»»»»»»»»»»                                
          
                                        ==============================================================================================================================
                                        ******************************************************************************************************************************
                """;
        System.out.println(menuDeidiomas);
        System.out.println("                                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                         *** 📣 INGRESE LA OPCION DE SU IDIOMA DE PREFERENCIA USANDO LAS INICIALES SEGUN IDIOMA 📣 ***");
        System.out.println("====================================================================================================================================================================");

        String lenguajeElegido = SCANNER.nextLine();
        // validacion...
        while (!idiomas.contains(lenguajeElegido)) {
            System.out.println("==================================================================================================================================");
            System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("        *******LO SENTIMOS ESTA OPCION NO ES VALIDA, INGRESA UNA OPCION DE LA LISTA USANDO LAS INICIALES SEGUN IDIOMA  *******              ");
            System.out.println("==================================================================================================================================\n");
            lenguajeElegido = SCANNER.nextLine();
        }

        List<DigitalBook> chivaDBBooks = bookRepository.filterDigitalBooksByIdioma(lenguajeElegido);

        if (chivaDBBooks.isEmpty()) {
            System.out.println("==================================================================================================================================");
            System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("                      *******LO SENTIMOS NO  EXISTEN LIBROS REGISTRADOS QUE CONTENGAN ESTE IDIOMA *******              ");
            System.out.println("==================================================================================================================================\n");

        } else {
            System.out.println("==============================================================================================================================================================================================================");
            System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
            System.out.println("                         *** [📘] DATOS DEL LIBROS QUE CONTENGAN ESTE IDIOMA  [📒] ***\n");
            chivaDBBooks.forEach(System.out::println);
            System.out.println("============================================================================================================================================================================================================\n");
        }
    }

    public void recordsDeLibros() {
        List<DigitalBook> chivaDBLibros = bookRepository.findAll();
        DoubleSummaryStatistics estadistics = chivaDBLibros .stream()
                .filter(l -> l.getDescargas() > 0)
                .collect(Collectors.summarizingDouble(DigitalBook::getDescargas));
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                                        *** [📘] STATUS DE DESCARGAS  [📒] ***\n");
        System.out.printf("Descargas: %s%nMaximas Descargas: %s%nMinimas Descargas: %s%nRegistro Total esatdistico de BD: %s%n",
                estadistics.getAverage(),estadistics.getMax(),estadistics.getMin(),estadistics.getCount());
        System.out.println("============================================================================================================================================================================================================\n");
    }

    public void top15GutendexAPI(){
        List<DigitalBookRecordData> LibrosGutendex = obtenerLibrosMasPopulares().stream()
                .limit(15)
                .collect(Collectors.toList());
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                 ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                               *** [📘] DATOS DE BUSQUEDA TOP LIBROS API [📒] ***\n");
        LibrosGutendex.forEach(b ->System.out.printf("🎇Titulo: **[%s]**🎇%n 👩‍💼Autor: **[%s]**👨‍💼%n 📣Idiomas: **[%s]**📣%n ⬇ Numero de Descargas: **[%s]**⬇%n"+
                "========================================================================================================================================================================================================================\n",
        b.titulo(), b.autor().get(0).nombre(), b.idioma().get(0), b.descargas()));

    }

    public void top5ChivaDB() {
        System.out.println("==============================================================================================================================================================================================================");
        System.out.println("                ******* 📖 * 📔 📙 📒 * [📚] LITERARIOS L@ CHIVA7🐐 [📚] * 📕 📗 📘 * 📖 *******");
        System.out.println("                                    *** [📘] TOP DATA BASE LIBROS  [📒] ***");
        System.out.println("===============================================================================================================================================================================================================");
        List<DigitalBook> chivaDBLibros = bookRepository.filterDigitalBooksByDescargas();
        chivaDBLibros.forEach(s-> System.out.println("📒Libro: ** [" + s.getTitulo()+ "] **📕\n Idioma: **📣["+ s.getIdioma()+"] **📣\n Numero de Descargas: **⬇[" + s.getDescargas()+ "] **⬇\n 👩‍💼************ Datos de Aut@r ************👨‍💼 \n " + s.getAuthor()+"\n"));
        System.out.println("===============================================================================================================================================================================================================");

    }


}


