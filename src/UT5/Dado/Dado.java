package UT5.Dado;
import java.util.Random;

/**
 * La clase Dado representa un dado utilizado en juegos de mesa o simulaciones.
 */
public class Dado {

    private int identificador;
    /**
     * La variable estática 'ultimoIdentificador' se utiliza para asignar identificadores únicos a cada instancia de la clase Dado.
     * Cada vez que se crea un nuevo objeto Dado, 'ultimoIdentificador' se incrementa, y el valor resultante se asigna al identificador del objeto.
     * Esto asegura que cada dado tenga un identificador único, ya que la variable 'ultimoIdentificador' es compartida por todas las instancias de la clase.
     */
    private static int ultimoIdentificador;
    private int nCaras;
    private int modificador;
    private Random random;

    /**
     * Constructor por defecto que inicializa un dado de 6 caras sin modificador.
     */
    public Dado() {
        Dado.ultimoIdentificador++;
        this.identificador = Dado.ultimoIdentificador;
        this.nCaras = 6;
        this.modificador = 0;
        this.random = new Random();
    }

    /**
     * Constructor que permite especificar el número de caras y un modificador.
     * @param nCaras Número de caras del dado (debe ser 4, 6, 8, 10, 12, 20 o 100).
     * @param modificador Valor que se suma al resultado del dado.
     */
    public Dado(int nCaras, int modificador) {
        Dado.ultimoIdentificador++;
        identificador = Dado.ultimoIdentificador;
        if (comprobarCaras()) {
            this.nCaras = nCaras;
        } else {
            // Si el número de caras no es válido, se establece el valor por defecto a 6.
            this.nCaras = 6;
        }
        this.modificador = modificador;
        this.random = new Random();
    }

    /**
     * Obtiene el identificador único del dado.
     * @return El identificador del dado.
     */
    public int getIdentificador() {
        return this.identificador;
    }

    /**
     * Establece un nuevo identificador para el dado.
     * @param identificador Nuevo identificador del dado.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtiene el número de caras del dado.
     * @return El número de caras del dado.
     */
    public int getNCaras() {
        return this.nCaras;
    }

    /**
     * Establece un nuevo número de caras para el dado.
     * @param nCaras Nuevo número de caras del dado.
     */
    public void setNCaras(int nCaras) {
        if (comprobarCaras()) {
            this.nCaras = nCaras;
        } else {
            // Si el número de caras no es válido, se establece el valor por defecto a 6.
            this.nCaras = 6;
        }
    }

    /**
     * Obtiene el modificador actual del dado.
     * @return El modificador del dado.
     */
    public int getModificador() {
        return this.modificador;
    }

    /**
     * Establece un nuevo modificador para el dado.
     * @param modificador Nuevo modificador del dado.
     */
    public void setModificador(int modificador) {
        this.modificador = modificador;
    }

    /**
     * Incrementa el modificador actual en 1.
     */
    public void incrementarMod() {
        this.modificador++;
    }

    /**
     * Decrementa el modificador actual en 1.
     */
    public void decrementarMod() {
        this.modificador--;
    }

    /**
     * Comprueba que el numero de caras sea valido
     * @return true si es valido
     */
    public boolean comprobarCaras(){
        return nCaras == 4 || nCaras == 6 || nCaras == 8 || nCaras == 10 || nCaras == 12 || nCaras == 20 || nCaras == 100;
    }

    /**
     * Simula el lanzamiento del dado y devuelve un valor aleatorio entre 1 y el número de caras.
     * @return El resultado del lanzamiento del dado.
     */
    public int tirarDado() {
        return random.nextInt(this.nCaras) + 1;
    }

    /**
     * Simula el lanzamiento del dado con modificador y devuelve un valor entre 1 y el número de caras más el modificador.
     * @return El resultado del lanzamiento del dado con modificador.
     */
    public int tirarDadoMod() {
        return tirarDado() + this.modificador;
    }

    /**
     * Simula el lanzamiento del dado varias veces y devuelve la suma de los resultados.
     * @param veces Número de veces que se lanzará el dado.
     * @return La suma de los resultados de los lanzamientos.
     */
    public int tirarDados(int veces) {
        int resultado = 0;
        for (int i = 0; i < veces; i++) {
            resultado += tirarDado();
        }
        return resultado;
    }

    /**
     * Simula el lanzamiento del dado con modificador varias veces y devuelve la suma de los resultados.
     * @param veces Número de veces que se lanzará el dado con modificador.
     * @return La suma de los resultados de los lanzamientos con modificador.
     */
    public int tirarDadosMod(int veces) {
        int resultado = 0;
        for (int i = 0; i < veces; i++) {
            resultado += tirarDadoMod();
        }
        return resultado;
    }

    public int tirarDadosMod2(int veces) {
        return tirarDados(veces)+this.modificador*veces;
    }

    /**
     * Simula un lanzamiento de dado con ventaja y devuelve el mayor de los dos resultados.
     * @return El resultado del lanzamiento de dado con ventaja.
     */
    public int tirarConVentaja() {
        int dado1 = tirarDado();
        int dado2 = tirarDado();
        if (dado1 > dado2) return dado1;
        else return dado2;
    }

    /**
     * Simula un lanzamiento de dado con ventaja y modificador, devolviendo el mayor de los dos resultados.
     * @return El resultado del lanzamiento de dado con ventaja y modificador.
     */
    public int tirarConVentajaMod() {
        int dado1 = tirarDadoMod();
        int dado2 = tirarDadoMod();
        if (dado1 > dado2) return dado1;
        else return dado2;
    }

    /**
     * Simula un lanzamiento de dado con desventaja y devuelve el menor de los dos resultados.
     * @return El resultado del lanzamiento de dado con desventaja.
     */
    public int tirarConDesventaja() {
        int dado1 = tirarDado();
        int dado2 = tirarDado();
        if (dado1 < dado2) return dado1;
        else return dado2;
    }

    /**
     * Simula un lanzamiento de dado con desventaja y modificador, devolviendo el menor de los dos resultados.
     * @return El resultado del lanzamiento de dado con desventaja y modificador.
     */
    public int tirarConDesventajaMod() {
        int dado1 = tirarDadoMod();
        int dado2 = tirarDadoMod();
        if (dado1 < dado2) return dado1;
        else return dado2;
    }

    /**
     * Simula un lanzamiento de dado haciendo trampa y devuelve un valor entre 1 y el doble de caras, pero limitado al número de caras.
     * @return El resultado del lanzamiento de dado haciendo trampa.
     */
    public int hacerTrampa() {
        int resultado = random.nextInt(nCaras * 2) + 1;
        if (resultado > nCaras) resultado = nCaras;
        return resultado;
    }

    /**
     * Simula un lanzamiento de dado haciendo trampa con una probabilidad del 80% de obtener el valor máximo de caras.
     * @return El resultado del lanzamiento de dado haciendo trampa.
     */
    public int hacerTrampa2() {
        int resultado;
        if (random.nextInt(101) < 80) {
            resultado = nCaras;
        } else {
            resultado = tirarDado();
        }
        return resultado;
    }

    /**
     * Simula un lanzamiento de dado haciendo trampa con modificador y devuelve un valor entre 1 y el doble de caras más el modificador, limitado al número de caras.
     * @return El resultado del lanzamiento de dado haciendo trampa con modificador.
     */
    public int hacerTrampaMod() {
        return hacerTrampa() + this.modificador;
    }

    /**
     * Simula un lanzamiento de dado haciendo trampa con ventaja y modificador, devolviendo el mayor de los dos resultados.
     * @return El resultado del lanzamiento de dado haciendo trampa con ventaja y modificador.
     */
    public int trampaVentajaMod() {
        int dado1 = hacerTrampaMod();
        int dado2 = hacerTrampaMod();
        if (dado1 > dado2) return dado1;
        else return dado2;
    }

    /**
     * Simula un lanzamiento de dado haciendo trampa con desventaja y modificador, devolviendo el menor de los dos resultados.
     * @return El resultado del lanzamiento de dado haciendo trampa con desventaja y modificador.
     */
    public int trampaDesventajaMod() {
        int dado1 = hacerTrampaMod();
        int dado2 = hacerTrampaMod();
        if (dado1 < dado2) return dado1;
        else return dado2;
    }
}
