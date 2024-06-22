import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from PIL import Image, ImageTk
from Autor import Autor
from Biblioteca import Biblioteca
from Categoria import Categoria
from Libro import Libro
from Prestamo import Prestamo
from Usuario import Usuario

class BibliotecaApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Biblioteca App")

        # Ajustar tamaño de la ventana y centrar en la pantalla
        self.root.geometry("500x700")
        screen_width = self.root.winfo_screenwidth()
        screen_height = self.root.winfo_screenheight()
        x = (screen_width // 2) - (400 // 2)
        y = (screen_height // 2) - (650 // 2)
        self.root.geometry(f"500x700+{x}+{y}")

        self.frame_imagen = ttk.Frame(self.root, style="TFrame")
        self.frame_imagen.pack(pady=10, padx=10, fill=tk.BOTH, expand=True)
        imagen = Image.open("BIBLIOTECA/biblioxd.jpg")
        imagen = imagen.resize((270, 200))
        self.imagen_tk = ImageTk.PhotoImage(imagen)
        self.label_imagen = ttk.Label(self.frame_imagen, image=self.imagen_tk)
        self.label_imagen.pack()

        # Crear una instancia de Biblioteca
        self.biblioteca = Biblioteca()  # Mover esta línea aquí

        # Estilo para los widgets
        self.style = ttk.Style()
        self.style.configure("TFrame", background="#f0f0f0")
        self.style.configure("TLabel", background="#f0f0f0", font=("Arial", 10))
        self.style.configure("TEntry", fieldbackground="#ffffff")
        self.style.configure("TButton", background="#e0e0e0", font=("Arial", 10))

        # Frame para el registro de libros
        self.frame_registro_libro = ttk.Frame(self.root, style="TFrame")
        self.frame_registro_libro.pack(pady=10, padx=10, fill=tk.BOTH, expand=True)

        ttk.Label(self.frame_registro_libro, text="Registrar Libro", font=("Arial", 12, "bold")).grid(row=0, column=0, columnspan=2, padx=5, pady=5, sticky="w")

        ttk.Label(self.frame_registro_libro, text="Título").grid(row=1, column=0, padx=5, pady=5, sticky="w")
        self.entry_titulo = ttk.Entry(self.frame_registro_libro)
        self.entry_titulo.grid(row=1, column=1, padx=5, pady=5, sticky="ew")

        ttk.Label(self.frame_registro_libro, text="ISBN").grid(row=2, column=0, padx=5, pady=5, sticky="w")
        self.entry_isbn = ttk.Entry(self.frame_registro_libro)
        self.entry_isbn.grid(row=2, column=1, padx=5, pady=5, sticky="ew")

        ttk.Button(self.frame_registro_libro, text="Registrar Libro", command=self.registrar_libro).grid(row=3, column=0, columnspan=2, padx=5, pady=10)

        # Frame para seleccionar y mostrar libros disponibles
        self.frame_mostrar_libros = ttk.Frame(self.root, style="TFrame")
        self.frame_mostrar_libros.pack(pady=10, padx=10, fill=tk.BOTH, expand=True)

        ttk.Label(self.frame_mostrar_libros, text="Seleccionar Libro", font=("Arial", 12, "bold")).grid(row=0, column=0, columnspan=2, padx=5, pady=5, sticky="w")

        self.combo_libros = ttk.Combobox(self.frame_mostrar_libros, state="readonly", width=30)
        self.combo_libros.grid(row=1, column=0, columnspan=2, padx=5, pady=5)
        self.combo_libros.bind("<<ComboboxSelected>>", self.mostrar_info_libro)

        self.label_info_libro = ttk.Label(self.frame_mostrar_libros, text="", font=("Arial", 10), wraplength=380)
        self.label_info_libro.grid(row=2, column=0, columnspan=2, padx=10, pady=5)

        self.actualizar_combo_libros()

        # Frame para el registro de usuarios
        self.frame_registro_usuario = ttk.Frame(self.root, style="TFrame")
        self.frame_registro_usuario.pack(pady=10, padx=10, fill=tk.BOTH, expand=True)

        ttk.Label(self.frame_registro_usuario, text="Registrar Usuario", font=("Arial", 12, "bold")).grid(row=0, column=0, columnspan=2, padx=5, pady=5, sticky="w")

        ttk.Label(self.frame_registro_usuario, text="Nombre").grid(row=1, column=0, padx=5, pady=5, sticky="w")
        self.entry_nombre = ttk.Entry(self.frame_registro_usuario)
        self.entry_nombre.grid(row=1, column=1, padx=5, pady=5, sticky="ew")

        ttk.Label(self.frame_registro_usuario, text="Apellido").grid(row=2, column=0, padx=5, pady=5, sticky="w")
        self.entry_apellido = ttk.Entry(self.frame_registro_usuario)
        self.entry_apellido.grid(row=2, column=1, padx=5, pady=5, sticky="ew")

        ttk.Button(self.frame_registro_usuario, text="Registrar Usuario", command=self.registrar_usuario).grid(row=3, column=0, columnspan=2, padx=5, pady=10)

        # Crear una instancia de Biblioteca
        self.biblioteca = Biblioteca()

    def registrar_libro(self):
        titulo = self.entry_titulo.get()
        isbn = self.entry_isbn.get()
        autor = Autor("Gabriel", "García Márquez")
        categoria = Categoria("Ficción")
        libro = Libro(titulo, isbn, autor, categoria)
        self.biblioteca.registrar_libro(libro)
        self.actualizar_combo_libros()
        self.entry_titulo.delete(0, tk.END)
        self.entry_isbn.delete(0, tk.END)
        messagebox.showinfo("Registro exitoso", f"Libro '{titulo}' registrado con éxito")

    def actualizar_combo_libros(self):
        libros_disponibles = [libro.titulo for libro in self.biblioteca.libros]
        self.combo_libros["values"] = libros_disponibles

    def mostrar_info_libro(self, event):
        selected_book = self.combo_libros.get()
        if selected_book:
            libro = self.biblioteca.buscar_libro_por_titulo(selected_book)
            if libro:
                info = f"Título: {libro.titulo}\nISBN: {libro.isbn}\nAutor: {libro.autor.nombre} {libro.autor.apellido}\nCategoría: {libro.categoria.nombre}"
                self.label_info_libro.config(text=info)
            else:
                self.label_info_libro.config(text="No se encontró información del libro seleccionado.")
        else:
            self.label_info_libro.config(text="")

    def registrar_usuario(self):
        nombre = self.entry_nombre.get()
        apellido = self.entry_apellido.get()
        usuario = Usuario(nombre, apellido, 12345)
        self.biblioteca.registrar_usuario(usuario)
        self.entry_nombre.delete(0, tk.END)
        self.entry_apellido.delete(0, tk.END)
        messagebox.showinfo("Registro exitoso", "usuario registrado con éxito")


# Instanciar y correr la aplicación
if __name__ == "__main__":
    root = tk.Tk()
    app = BibliotecaApp(root)
    root.mainloop()


