import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBiblioteca");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Listar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    biblioteca.agregarLibro(titulo, autor, isbn);
                    break;

                case 2:
                    System.out.print("Ingrese el título a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    List<Libro> resultadosTitulo = biblioteca.buscarPorTitulo(tituloBusqueda);
                    if (!resultadosTitulo.isEmpty()) {
                        System.out.println("\nLibros encontrados:");
                        for (Libro libro : resultadosTitulo) {
                            System.out.println("- " + libro.getTitulo() + " (" + libro.getAutor() + ") | ISBN: " + libro.getIsbn());
                        }
                    } else {
                        System.out.println("No se encontraron libros con ese título.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el autor que desea buscar: ");
                    String autorBusqueda = scanner.nextLine();
                    List<Libro> resultadosAutor = biblioteca.buscarPorAutor(autorBusqueda);
                    if (!resultadosAutor.isEmpty()) {
                        System.out.println("\nLibros encontrados:");
                        for (Libro libro : resultadosAutor) {
                            System.out.println("- " + libro.getTitulo() + " (" + libro.getAutor() + ") | ISBN: " + libro.getIsbn());
                        }
                    } else {
                        System.out.println("No se encontraron libros de ese autor.");
                    }
                    break;

                case 4:
                    biblioteca.listarLibros();
                    break;

                case 5:
                    System.out.println("Saliendo del programa . . .");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}