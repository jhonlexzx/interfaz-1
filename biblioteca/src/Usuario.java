public class Usuario {
    private String nombre;
    private String apellido;
    private String idUsuario;

    public Usuario(String nombre, String apellido, String idUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("ID de Usuario: " + idUsuario);
    }
}

