package UT5.Biblioteca;

import java.io.Console;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BibliotecaTerminal {
    Scanner sc;
    Biblioteca biblioteca;

    private static final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public BibliotecaTerminal(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        sc = new Scanner(System.in);
    }

    public void cerrarTerminal() {
        sc.close();
    }

    public void loopPrincipal() {
        //loopInicioSesion();
        biblioteca.inicioSesion("javierd", "password2");
        if (biblioteca.getSesion().getEsAdmin()) {
            loopPrincipalAdmin();
        } else {
            loopPrincipalUsuario();
        }

        cerrarTerminal();
    }

    public void loopPrincipalAdmin() {
        boolean salir = false;
        while (!salir) {
            mostrarMenuGeneralAdmin();
            int opcion = pedirNumero(1, 14);
            switch (opcion) {
                case 1 -> addLibro();
                case 2 -> eliminarLibro();
                case 3 -> buscarLibro();
                case 4 -> mostrarLibros();
                case 5 -> registrarUsuario();
                case 6 -> consultarUsuarios();
                case 7 -> realizarPrestamo();
                case 8 -> devolverPrestamo();
                case 9 -> mostrarPrestamos();
                case 10 -> mostrarPrestados();
                case 11 -> mostrarLibrosMasPrestados();
                case 12 -> mostrarUsuariosMasPrestamos();
                case 13 -> salir = true;
            }
            esperarTecla();
            limpiarConsola();
        }
    }

    public void loopPrincipalUsuario() {

    }

    public void loopInicioSesion() {
        boolean sesion = false;
        mostrarMenuSesion();
        while (!sesion) {
            System.out.println("Introduce el nombre de usuario");
            String nick = pedirString();
            System.out.println("Introduce tu contraseña");
            String pass = pedirContrasena();
            sesion = biblioteca.inicioSesion(nick, pass);
            if (!sesion)
                System.out.println("El nombre de usuario o la contraseña no son correctos, intentalo de nuevo");
        }
    }

    public void addLibro() {
        Libro libro = pedirLibro();
        if (biblioteca.addLibro(libro)) {
            System.out.println("Libro añadido correctamente");
        } else {
            System.out.println("Ha ocurrido un erro al añadir el libro");
        }
    }

    public void eliminarLibro() {
        Libro l = null;
        mostrarMenuBusquedaLibroLight();
        int opcion = pedirNumero(1, 3);
        if (opcion != 3){
            if (opcion == 1){
                System.out.println("Introduce el título");
                l = biblioteca.buscarLibro(pedirString());
            }else if (opcion == 2){
                System.out.println("Introduce el ISBN");
                l = biblioteca.buscarLibroPorISBN(pedirString());
            }
            if (l != null) {
                System.out.println("¿Deseas eliminar el siguiente libro? (Y/N)");
                System.out.println(l.toString());
                if (pedirBooleano()) {
                    if (biblioteca.eliminarLibroPorISBN(l.getISBN())){
                        System.out.println("Libro eliminado correctamente");
                    }
                }
            }
        }
    }

    public void buscarLibro() {
        Libro l = null;
        Libro[] ls = null;
        mostrarMenuBusquedaLibro();
        int opcion = pedirNumero(1, 6);
        switch (opcion) {
            case 1:
                System.out.println("Introduce el titulo");
                l = biblioteca.buscarLibro(pedirString());
                if (l != null)
                    System.out.println(l.toString());
                else {
                    System.out.println("Libro no encontrado");
                }
                break;
            case 2:
                System.out.println("Introduce el ISBN");
                l = biblioteca.buscarLibroPorISBN(pedirString());
                if (l != null)
                    System.out.println(l.toString());
                else {
                    System.out.println("Libro no encontrado");
                }
                break;
            case 3:
                System.out.println("Introduce el autor");
                ls = biblioteca.buscarLibrosPorAutor(pedirString());
                if (ls != null && ls.length > 0) {
                    System.out.println(GestorLibro.toString(ls));
                } else {
                    System.out.println("No se ha encontrado ningún libro");
                }
                break;
            case 4:
                System.out.println("Selecciona la categoria");
                ls = biblioteca.buscarLibrosPorCategoria(pedirCategoria());
                if (ls != null && ls.length > 0) {
                    System.out.println(GestorLibro.toString(ls));
                } else {
                    System.out.println("No se ha encontrado ningún libro");
                }
                break;
        }

    }

    public void mostrarLibros() {
        System.out.println(biblioteca.getExistencias());
    }

    public void registrarUsuario() {

    }

    public void consultarUsuarios() {

    }

    public void realizarPrestamo() {

    }

    public void devolverPrestamo() {

    }

    public void mostrarPrestados() {

    }

    public void mostrarPrestamos() {

    }

    public void mostrarLibrosMasPrestados() {

    }

    public void mostrarUsuariosMasPrestamos() {

    }

    public void mostrarMenuGeneralAdmin() {
        System.out.println(YELLOW +
                "  *******************************************  \n" +
                "  *                                         *  \n" +
                "  *          BIBLIOTECA CENTRAL             *  \n" +
                "  *                                         *  \n" +
                "  *******************************************" + RESET);

        System.out.println(BLUE +
                "\n   =======================================" +
                "\n  ||          GESTIÓN DE LIBROS          ||" +
                "\n   =======================================");
        System.out.println("  [1] Añadir un libro");
        System.out.println("  [2] Eliminar un libro");
        System.out.println("  [3] Buscar un libro");
        System.out.println("  [4] Mostrar todos los libros");

        System.out.println(GREEN +
                "\n   =======================================" +
                "\n  ||         GESTIÓN DE USUARIOS         ||" +
                "\n   =======================================");
        System.out.println("  [5] Registrar nuevo usuario");
        System.out.println("  [6] Consultar usuarios registrados");

        System.out.println(YELLOW +
                "\n   =======================================" +
                "\n  ||        GESTIÓN DE PRÉSTAMOS         ||" +
                "\n   =======================================");
        System.out.println("  [7] Realizar préstamo de libro");
        System.out.println("  [8] Devolver libro prestado");
        System.out.println("  [9] Mostrar libros prestados");

        System.out.println(CYAN +
                "\n   =======================================" +
                "\n  ||       ESTADÍSTICAS Y REPORTES       ||" +
                "\n   =======================================");
        System.out.println("  [10] Número de préstamos totales y activos");
        System.out.println("  [11] Libros más prestados");
        System.out.println("  [12] Usuario con más préstamos activos");

        System.out.println(RED +
                "\n   =======================================" +
                "\n  [13]              SALIR                ||" +
                "\n   =======================================");

        System.out.println(PURPLE +
                "\n   ***********************************" +
                "\n  *  Seleccione una opción ingresando *" +
                "\n  *  el número correspondiente.       *" +
                "\n   ***********************************" + RESET);
    }

    public void mostrarMenuGeneralUsuario() {
        System.out.println(YELLOW +
                "  *******************************************  \n" +
                "  *                                         *  \n" +
                "  *          BIBLIOTECA CENTRAL             *  \n" +
                "  *                                         *  \n" +
                "  *******************************************" + RESET);

        System.out.println(BLUE +
                "\n   =======================================" +
                "\n  ||          GESTIÓN DE LIBROS          ||" +
                "\n   =======================================");
        System.out.println("  [1] Buscar un libro");
        System.out.println("  [2] Mostrar todos los libros");

        System.out.println(YELLOW +
                "\n   =======================================" +
                "\n  ||        GESTIÓN DE PRÉSTAMOS         ||" +
                "\n   =======================================");
        System.out.println("  [3] Realizar préstamo de libro");
        System.out.println("  [4] Devolver libro prestado");

        System.out.println(RED +
                "\n   =======================================" +
                "\n  [5]               SALIR                ||" +
                "\n   =======================================");

        System.out.println(PURPLE +
                "\n   ***********************************" +
                "\n  *  Seleccione una opción ingresando *" +
                "\n  *  el número correspondiente.       *" +
                "\n   ***********************************" + RESET);
    }

    public void mostrarMenuSesion() {
        System.out.println(YELLOW +
                "  *******************************************  \n" +
                "  *                                         *  \n" +
                "  *          BIBLIOTECA CENTRAL             *  \n" +
                "  *                                         *  \n" +
                "  *******************************************" + RESET);

        System.out.println(BLUE +
                "\n   =======================================" +
                "\n  ||          INICIO DE SESIÓN           ||" +
                "\n   =======================================" + RESET);
    }

    public void mostrarMenuBusquedaLibro() {
        System.out.println("Elige un criterio de búsqueda");
        System.out.println("[1] - Por título");
        System.out.println("[2] - Por ISBN");
        System.out.println("[3] - Por autor");
        System.out.println("[4] - Por categoría");
    }

    public void mostrarMenuBusquedaLibroLight() {
        System.out.println("Elige un criterio de búsqueda");
        System.out.println("[1] - Por título");
        System.out.println("[2] - Por ISBN");
    }

    public Libro pedirLibro() {
        System.out.println("Escribe el titulo del libro");
        String titulo = pedirString();
        System.out.println("Escribe el autor del libro");
        String autor = pedirString();
        System.out.println("Escribe el ISBN");
        String ISBN = pedirString();
        System.out.println("Escribe la fecha (dd/MM/yyyy)");
        Date fecha = pedirFecha();
        System.out.println("Selecciona la categoria");
        CategoriaLibro categoriaLibro = pedirCategoria();

        return new Libro(titulo, autor, ISBN, fecha, categoriaLibro);
    }

    public Usuario pedirUsuario() {
        System.out.println("Escribe el nombre");
        String nombre = pedirString();
        System.out.println("Escribe los apellidos");
        String apellidos = pedirString();
        System.out.println("Escribe un nombre de usuario");
        String nick = pedirString();
        System.out.println("Escribe una contraseña");
        String pass = pedirContrasena();
        System.out.println("Escribe un email");
        String email = pedirString();
        System.out.println("¿El usuario será administrador? (y/n)");
        boolean esAdmin = pedirBooleano();

        return new Usuario(nombre, apellidos, nick, pass, email, esAdmin);
    }

    private String pedirString() {
        String string = "";
        while (string == "") {
            string = sc.nextLine();
        }
        return string;
    }

    private String pedirContrasena() {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("No se puede acceder a la consola. Intente ejecutar en una terminal real.");
        }
        char[] contrasenaChars = console.readPassword();
        return new String(contrasenaChars);
    }

    private int pedirNumero(int min, int max) {
        boolean lecturaCorrecta = false;
        int numero = 0;
        while (!lecturaCorrecta) {
            String numString = sc.nextLine();
            try {
                numero = Integer.parseInt(numString);
                if (numero >= min && numero < max) {
                    lecturaCorrecta = true;
                } else {
                    System.out.println("El número debe estar entre " + min + " y " + max + ", intentalo de nuevo");
                }
            } catch (Exception e) {
                System.out.println("Formato numérico incorrecto. Intentalo de nuevo.");
            }
        }
        return numero;
    }

    private boolean pedirBooleano() {
        boolean leido = false;
        boolean booleano = false;
        do {
            String leer = pedirString();
            if (leer.toLowerCase().equals("y") || leer.toLowerCase().equals("s")) {
                booleano = true;
                leido = true;
            } else if (leer.toLowerCase().equals("n")) {
                booleano = false;
                leido = true;
            } else {
                System.out.println("Formato incorrecto. Intentalo de nuevo.");
            }
        } while (!leido);
        return booleano;
    }

    private Date pedirFecha() {
        Date fecha = null;
        while (fecha == null) {
            String entrada = sc.nextLine();
            try {
                fecha = formato.parse(entrada);
            } catch (ParseException e) {
                System.out.println("Formato inválido. Intentalo de nuevo.");
            }
        }
        return fecha;
    }

    private CategoriaLibro pedirCategoria() {
        CategoriaLibro[] categorias = CategoriaLibro.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println(i + ": " + categorias[i].name());
        }
        int seleccion = pedirNumero(0, categorias.length);
        return categorias[seleccion];
    }

    private void limpiarConsola() {
        try {
            String sistemaOperativo = System.getProperty("os.name").toLowerCase();
            if (sistemaOperativo.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperarTecla() {
        System.out.println("Presiona Enter para continuar...");
        sc.nextLine();
    }

    public static void main(String[] args) {

    }
}
