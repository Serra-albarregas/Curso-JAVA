package UT5.Ejemplos.GestorDatos;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase principal para realizar pruebas con las clases Cancion y GestorCancion.
 * 
 * @author Pablo Collar Serradilla
 */
public class CancionMain {
    public static void main(String[] args) {
        GestorCancion gestor = new GestorCancion();

        // Crear canciones
        gestor.nuevaCancion(new Cancion("Imagine", "John Lennon", GeneroMusical.ROCK, crearFecha(1971, Calendar.OCTOBER, 11)));
        gestor.nuevaCancion(new Cancion("Billie Jean", "Michael Jackson", GeneroMusical.POP, crearFecha(1983, Calendar.JANUARY, 2)));
        gestor.nuevaCancion(new Cancion("Take Five", "Dave Brubeck", GeneroMusical.JAZZ, crearFecha(1959, Calendar.SEPTEMBER, 29)));
        gestor.nuevaCancion(new Cancion("Bohemian Rhapsody", "Queen", GeneroMusical.ROCK, crearFecha(1975, Calendar.OCTOBER, 31)));
        gestor.nuevaCancion(new Cancion("Thriller", "Michael Jackson", GeneroMusical.POP, crearFecha(1982, Calendar.NOVEMBER, 30)));
        gestor.nuevaCancion(new Cancion("What a Wonderful World", "Louis Armstrong", GeneroMusical.JAZZ, crearFecha(1967, Calendar.AUGUST, 16)));
        gestor.nuevaCancion(new Cancion("No Woman No Cry", "Bob Marley", GeneroMusical.REGGAE, crearFecha(1974, Calendar.OCTOBER, 25)));
        gestor.nuevaCancion(new Cancion("Hotel California", "Eagles", GeneroMusical.ROCK, crearFecha(1977, Calendar.FEBRUARY, 22)));
        gestor.nuevaCancion(new Cancion("Smooth Criminal", "Michael Jackson", GeneroMusical.POP, crearFecha(1988, Calendar.NOVEMBER, 14)));
        gestor.nuevaCancion(new Cancion("Yesterday", "The Beatles", GeneroMusical.ROCK, crearFecha(1965, Calendar.AUGUST, 6)));
        gestor.nuevaCancion(new Cancion("One Love", "Bob Marley", GeneroMusical.REGGAE, crearFecha(1977, Calendar.MAY, 15)));
        gestor.nuevaCancion(new Cancion("Purple Haze", "Jimi Hendrix", GeneroMusical.ROCK, crearFecha(1967, Calendar.MARCH, 17)));
        gestor.nuevaCancion(new Cancion("Like a Rolling Stone", "Bob Dylan", GeneroMusical.FOLK, crearFecha(1965, Calendar.JULY, 20)));
        gestor.nuevaCancion(new Cancion("Halo", "Beyoncé", GeneroMusical.R_B, crearFecha(2008, Calendar.JANUARY, 20)));
        gestor.nuevaCancion(new Cancion("La Macarena", "Los del Río", GeneroMusical.LATINO, crearFecha(1995, Calendar.JUNE, 12)));
        gestor.nuevaCancion(new Cancion("Dynamite", "BTS", GeneroMusical.K_POP, crearFecha(2020, Calendar.AUGUST, 21)));
        gestor.nuevaCancion(new Cancion("Livin' la Vida Loca", "Ricky Martin", GeneroMusical.LATINO, crearFecha(1999, Calendar.MARCH, 23)));
        gestor.nuevaCancion(new Cancion("Shape of You", "Ed Sheeran", GeneroMusical.POP, crearFecha(2017, Calendar.JANUARY, 6)));
        gestor.nuevaCancion(new Cancion("Boulevard of Broken Dreams", "Green Day", GeneroMusical.PUNK, crearFecha(2004, Calendar.OCTOBER, 29)));
        gestor.nuevaCancion(new Cancion("Rolling in the Deep", "Adele", GeneroMusical.SOUL, crearFecha(2010, Calendar.NOVEMBER, 29)));

        //Todas las canciones
        System.out.println("Todas las canciones:\n" + gestor.toString() + "\n");

        // Buscar canciones por título
        System.out.println("Buscar canción: " + gestor.buscarCancion("Imagine") + "\n");

        // Buscar canciones por autor
        System.out.println("Canciones de Michael Jackson:\n" + GestorCancion.toString(gestor.buscarPorAutor("Michael Jackson")) + "\n");

        // Buscar canciones por género
        System.out.println("Canciones de género JAZZ:\n" + GestorCancion.toString(gestor.buscarPorGenero(GeneroMusical.JAZZ)) + "\n");

        // Actualizar una canción
        Cancion cActualizada = new Cancion("Imagine", "John Lennon", GeneroMusical.CLASICA, new Date());
        gestor.actualizarCancion("Imagine", cActualizada);
        System.out.println("Canción actualizada:\n" + gestor.buscarCancion("Imagine") + "\n");

        // Eliminar una canción
        gestor.eliminarCancion("Billie Jean");
        System.out.println("Canciones después de eliminar:\n" + GestorCancion.toString(gestor.buscarPorAutor("Michael Jackson")) + "\n");

        //Todas las canciones para ver los cambios
        System.out.println("Todas las canciones:\n" + gestor.toString() + "\n");
    }


    public static Date crearFecha(int anio, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes, dia, 0, 0, 0); // Configura año, mes y día, hora en 00:00:00
        calendar.set(Calendar.MILLISECOND, 0); // Elimina los milisegundos
        return calendar.getTime();
    }
}


