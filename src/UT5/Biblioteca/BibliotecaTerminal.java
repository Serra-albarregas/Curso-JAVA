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
        loopInicioSesion();
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
            int opcion = pedirNumero();
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
                default -> System.out.println("Opcion incorrecta");
            }
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

    }

    public void eliminarLibro() {

    }

    public void buscarLibro() {

    }

    public void mostrarLibros() {

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

    private int pedirNumero() {
        Integer numero = null;
        while (numero == null) {
            String numString = sc.nextLine();
            try {
                numero = Integer.parseInt(numString);
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
        int seleccion = -1;
        do {
            seleccion = pedirNumero();
            if (seleccion < 0 || seleccion >= categorias.length) {
                System.out.println("La opcion seleccionada no existe. Intentalo de nuevo.");
            }
        } while (seleccion < 0 || seleccion >= categorias.length);
        return categorias[seleccion];
    }

    private void limpiarConsola(){
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
        sc.nextLine(); // Espera la entrada del usuario
    }

    public static void main(String[] args) {

    }
}
