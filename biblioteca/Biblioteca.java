import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void registrarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void realizarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }

}