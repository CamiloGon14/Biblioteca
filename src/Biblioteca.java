import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Lista privada de libros
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    // Método para agregar un libro
    public void agregarLibro(String titulo, String autor, String isbn) {
        Libro libro = new Libro(titulo, autor, isbn);
        libros.add(libro);
        System.out.println("Libro '" + titulo + "' agregado correctamente.");
    }

    // Método para buscar libros por título
    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    // Método para buscar libros por autor
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    // Método para listar todos los libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("\nLista de libros:");
            for (Libro libro : libros) {
                String estado = libro.isDisponible() ? "Disponible" : "Prestado";
                System.out.println("- " + libro.getTitulo() + " (" + libro.getAutor() + ") | ISBN: " + libro.getIsbn() + " | Estado: " + estado);
            }
        }
    }
}
