import java.time.LocalDate;

public class Prestamo {
    // Atributos privados
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    // Constructor
    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Métodos getter y setter para libro
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // Métodos getter y setter para usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Métodos getter y setter para fechaPrestamo
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    // Métodos getter y setter para fechaDevolucion
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Fecha de préstamo: " + fechaPrestamo);
        System.out.println("Fecha de devolución: " + fechaDevolucion);
    }

}
