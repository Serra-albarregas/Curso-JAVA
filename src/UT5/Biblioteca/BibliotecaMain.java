package UT5.Biblioteca;

import java.util.Calendar;
import java.util.Date;

public class BibliotecaMain {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728", crearFecha(1967, 5, 30), CategoriaLibro.NOVELA));
        biblioteca.addLibro(new Libro("El otoño del patriarca", "Gabriel García Márquez", "978-0307476784", crearFecha(1975, 9, 1), CategoriaLibro.NOVELA));
        biblioteca.addLibro(new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", "978-0307476807", crearFecha(1981, 4, 1), CategoriaLibro.NOVELA));
        biblioteca.addLibro(new Libro("1984", "George Orwell", "978-0451524935", crearFecha(1949, 6, 8), CategoriaLibro.CIENCIA_FICCION));
        biblioteca.addLibro(new Libro("Rebelión en la granja", "George Orwell", "978-0451526342", crearFecha(1945, 8, 17), CategoriaLibro.CIENCIA_FICCION));
        biblioteca.addLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien", "978-0544003415", crearFecha(1954, 7, 29), CategoriaLibro.FANTASIA));
        biblioteca.addLibro(new Libro("El hobbit", "J.R.R. Tolkien", "978-0547928227", crearFecha(1937, 9, 21), CategoriaLibro.FANTASIA));
        biblioteca.addLibro(new Libro("Fundación", "Isaac Asimov", "978-0553293357", crearFecha(1951, 5, 1), CategoriaLibro.CIENCIA_FICCION));
        biblioteca.addLibro(new Libro("Yo, Robot", "Isaac Asimov", "978-0553294385", crearFecha(1950, 12, 2), CategoriaLibro.CIENCIA_FICCION));
        biblioteca.addLibro(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "978-8478884452",crearFecha(1997, 6, 26), CategoriaLibro.FANTASIA));
        biblioteca.addLibro(new Libro("Harry Potter y la cámara secreta", "J.K. Rowling", "978-8478884957",crearFecha(1998, 7, 2), CategoriaLibro.FANTASIA));
        biblioteca.addLibro(new Libro("Los pilares de la Tierra", "Ken Follett", "978-0451225245",crearFecha(1989, 10, 1), CategoriaLibro.HISTORIA));
        biblioteca.addLibro(new Libro("Un mundo sin fin", "Ken Follett", "978-0451228376", crearFecha(2007, 10, 4),CategoriaLibro.HISTORIA));
        biblioteca.addLibro(new Libro("La sombra del viento", "Carlos Ruiz Zafón", "978-8408079545",crearFecha(2001, 4, 1), CategoriaLibro.NOVELA));
        biblioteca.addLibro(new Libro("El código Da Vinci", "Dan Brown", "978-0307474278", crearFecha(2003, 3, 18),CategoriaLibro.MISTERIO));
        biblioteca.addLibro(new Libro("Ángeles y demonios", "Dan Brown", "978-0552161268", crearFecha(2000, 5, 1),CategoriaLibro.MISTERIO));
        biblioteca.addLibro(new Libro("El alquimista", "Paulo Coelho", "978-0062315007", crearFecha(1988, 4, 1),CategoriaLibro.FICCION));
        biblioteca.addLibro(new Libro("Brida", "Paulo Coelho", "978-0061124266", crearFecha(1990, 5, 1), CategoriaLibro.FICCION));
        biblioteca.addLibro(new Libro("Sherlock Holmes: Estudio en escarlata", "Arthur Conan Doyle", "978-8491050410",crearFecha(1887, 3, 1), CategoriaLibro.MISTERIO));
        biblioteca.addLibro(new Libro("El sabueso de los Baskerville", "Arthur Conan Doyle", "978-8491050625",crearFecha(1902, 4, 1), CategoriaLibro.MISTERIO));

        biblioteca.addUsuario(new Usuario("Juan", "Pérez", "juanp", "1234", "juan@email.com", false));
        biblioteca.addUsuario(new Usuario("Ana", "García", "anag", "abcd", "ana@email.com", false));
        biblioteca.addUsuario(new Usuario("Carlos", "López", "carlosl", "qwerty", "carlos@email.com", false));
        biblioteca.addUsuario(new Usuario("María", "Martínez", "mariam", "password", "maria@email.com", false));
        biblioteca.addUsuario(new Usuario("Luis", "Gómez", "luisg", "5678", "luis@email.com", false));
        biblioteca.addUsuario(new Usuario("Pedro", "Sánchez", "pedros", "8765", "pedro@email.com", false));
        biblioteca.addUsuario(new Usuario("Sofia", "Torres", "sofia_t", "abc123", "sofia@email.com", false));
        biblioteca.addUsuario(new Usuario("Elena", "Fernández", "elenaf", "qazwsx", "elena@email.com", false));
        biblioteca.addUsuario(new Usuario("David", "Ramírez", "davidr", "password1", "david@email.com", false));
        biblioteca.addUsuario(new Usuario("Javier", "Díaz", "javierd", "password2", "javier@email.com", true));
        biblioteca.addUsuario(new Usuario("Isabel", "Jiménez", "isabelj", "pass123", "isabel@email.com", true));
        try {
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0307476784"), biblioteca.buscarUsuario("anag"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0451228376"), biblioteca.buscarUsuario("anag"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0307474728"), biblioteca.buscarUsuario("anag"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0307476807"), biblioteca.buscarUsuario("carlosl"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-8408079545"), biblioteca.buscarUsuario("carlosl"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0451524935"), biblioteca.buscarUsuario("mariam"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0307474278"), biblioteca.buscarUsuario("mariam"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0451526342"), biblioteca.buscarUsuario("luisg"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0552161268"), biblioteca.buscarUsuario("luisg"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0544003415"), biblioteca.buscarUsuario("pedros"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0062315007"), biblioteca.buscarUsuario("pedros"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0547928227"), biblioteca.buscarUsuario("sofia_t"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0061124266"), biblioteca.buscarUsuario("sofia_t"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0553293357"), biblioteca.buscarUsuario("elenaf"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-8491050410"), biblioteca.buscarUsuario("elenaf"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0553294385"), biblioteca.buscarUsuario("davidr"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-8478884452"), biblioteca.buscarUsuario("javierd"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-8478884957"), biblioteca.buscarUsuario("isabelj"));
            biblioteca.prestar(biblioteca.buscarLibroPorISBN("978-0451225245"), biblioteca.buscarUsuario("juanp"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        BibliotecaTerminal bt = new BibliotecaTerminal(biblioteca);
        bt.loopPrincipal();
    }

    public static Date crearFecha(int anio, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes, dia, 0, 0, 0); // Configura año, mes y día, hora en 00:00:00
        calendar.set(Calendar.MILLISECOND, 0); // Elimina los milisegundos
        return calendar.getTime();
    }
}
