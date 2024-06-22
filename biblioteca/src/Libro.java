public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private Categoria categoria;

    public Libro(String titulo, String isbn, String autor, Categoria categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Autor: " + autor);
        System.out.println("Categoría: " + categoria.getNombre());
    }

}
