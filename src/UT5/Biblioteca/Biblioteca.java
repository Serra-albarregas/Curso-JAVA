package UT5.Biblioteca;

public class Biblioteca {
    private GestorLibro existencias;
    private GestorLibro prestados;
    private GestorUsuario usuarios;
    private Usuario sesion;
    private int totalPrestados;
    private static final int TAM = 50;


    public Biblioteca () {
        existencias = new GestorLibro(TAM);
        prestados = new GestorLibro(TAM);
        usuarios = new GestorUsuario(TAM);
        sesion = null;
        totalPrestados = 0;
    }

    public boolean addLibro(Libro l){
        return existencias.addLibro(l);
    }

    public boolean eliminarLibro(String titulo){
        return existencias.eliminarLibro(titulo);
    }

    public boolean eliminarLibroPorISBN(String ISBN){
        if (existencias.buscarPorISBN(ISBN).getDisponible())
            return existencias.eliminarLibroPorISBN(ISBN);
        else
            return false;
    }

    public Libro buscarLibro(String titulo) {
        return existencias.buscarPorTitulo(titulo);
    }

    public Libro buscarLibroPorISBN(String ISBN) {
        return existencias.buscarPorISBN(ISBN);
    }

    public Libro[] buscarLibrosPorAutor(String autor) {
        return existencias.buscarPorAutor(autor);
    }

    public Libro[] buscarLibrosPorCategoria(CategoriaLibro categoria){
        return existencias.buscarPorCategoria(categoria);
    }

    public boolean addUsuario(Usuario u){
        return usuarios.addUsuario(u);
    }

    public Usuario buscarUsuario(String nick){
        return usuarios.buscarUsuario(nick);
    }
    
    public boolean inicioSesion(String nick, String pass){
        Usuario u = usuarios.buscarUsuario(nick);
        if (u!=null && u.getPass().equals(pass)){
            sesion = u;
            return true;
        }
        else{
            return false;
        }
    }

    public Usuario getSesion(){
        return this.sesion;
    }

    public int getTotalPrestados(){
        return totalPrestados;
    }

    public int getPrestadosActuales(){
        return prestados.getLleno();
    }

    public int getNumeroUsuarios(){
        return usuarios.getLleno();
    }

    public String stringExistencias(){
        return this.existencias.infoLibros();
    }

    public String stringUsuarios(){
        return this.usuarios.infoUsuarios();
    }

    public String stringPrestados(){
        return this.prestados.infoLibrosAdmin();
    }

    public void prestar(Libro libro) throws Exception{
        if (!sesion.puedePedir()){
            throw new Exception("El libro no está disponible.");
        }
        if (!libro.getDisponible()){
            throw new Exception("El libro no está disponible.");
        }
        sesion.pedirPrestado(libro);
        libro.prestar(sesion);
        prestados.addLibro(libro);
        totalPrestados++;
    }

    public void prestar(Libro libro, Usuario usuario) throws Exception{
        if (!usuario.puedePedir()){
            throw new Exception("El libro no está disponible.");
        }
        if (!libro.getDisponible()){
            throw new Exception("El libro no está disponible.");
        }
        usuario.pedirPrestado(libro);
        libro.prestar(usuario);
        prestados.addLibro(libro);
        totalPrestados++;
    }

    public void devolver(Libro libro) throws Exception{
        if (sesion.getPrestados().buscarPorISBN(libro.getISBN())==null){
            throw new Exception("No tienes prestado el libro selecionado");
        }
        if (libro.getPrestadoA()==null){
            throw new Exception("El libro no está marcado como prestado");
        }
        sesion.devolver(libro);
        libro.setPrestadoA(null);
        prestados.eliminarLibroPorISBN(libro.getISBN());
    }

    public Libro[] librosMasPrestados(){
        int devueltos=3;
        Libro[] masPrestados = new Libro[devueltos];
        Libro[] aux = prestados.getLibros();
        for (int i = 0; i<devueltos;i++){
            Libro masPrestado = null;
            int iMasPrestado=0;
            int j = 0;
            while (masPrestado==null) {
                masPrestado = aux[j];
                iMasPrestado = j;
                j++;
            }
            for (;j < aux.length; j++) {
                Libro libro = aux[j];
                if (libro!=null && libro.getVecesPrestado()>masPrestado.getVecesPrestado()){
                    masPrestado=libro;
                    iMasPrestado=j;
                }
            }
            aux[iMasPrestado]=null;
            masPrestados[i]=masPrestado;
        }
        return masPrestados;
    }

    public Usuario[] usuariosConMasPrestamos(){
        int devueltos=3;
        Usuario[] masPrestamos = new Usuario[devueltos];
        Usuario[] aux = usuarios.getUsuarios();
        for (int i = 0; i<devueltos;i++){
            Usuario max = aux[0];
            int iMasPrestado=0;
            int j = 0;
            while (max==null) {
                max = aux[j];
                iMasPrestado = j;
                j++;
            }
            for (; j < aux.length; j++) {
                Usuario usuario = aux[j];
                if (usuario!=null && usuario.getPrestados().getLleno()>max.getPrestados().getLleno()){
                    max=usuario;
                    iMasPrestado=j;
                }
            }
            aux[iMasPrestado]=null;
            masPrestamos[i]=max;
        }
        return masPrestamos;
    }
}
