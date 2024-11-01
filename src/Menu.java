package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private ColeccionVinilos coleccion;
    private Scanner scanner;

    public Menu() {
        this.coleccion = new ColeccionVinilos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = -1;
        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarVinilo();
                        break;
                    case 2:
                        buscarVinilo();
                        break;
                    case 3:
                        mostrarColeccion();
                        break;
                    case 4:
                        mostrarCantidadVinilos();
                        break;
                    case 5:
                        mostrarEspaciosDisponibles();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú Colección de Vinilos ---");
        System.out.println("1. Agregar Vinilo");
        System.out.println("2. Buscar Vinilo");
        System.out.println("3. Mostrar Colección");
        System.out.println("4. Mostrar Cantidad de Vinilos");
        System.out.println("5. Mostrar Espacios Disponibles");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarVinilo() {
        try {
            System.out.print("Ingrese el nombre del artista: ");
            String artista = scanner.nextLine();
            System.out.print("Ingrese el nombre del disco: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese el año de lanzamiento: ");
            int anio = scanner.nextInt();
            scanner.nextLine();

            Vinilo nuevoVinilo = new Vinilo(artista, titulo, anio);
            if (coleccion.agregarVinilo(nuevoVinilo)) {
                System.out.println("Vinilo agregado exitosamente.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Año de lanzamiento inválido. Debe ser un número.");
            scanner.nextLine();
        }
    }

    private void buscarVinilo() {
        System.out.print("Ingrese el título del vinilo que desea buscar: ");
        String titulo = scanner.nextLine();
        boolean encontrado = coleccion.buscarVinilo(titulo);
        if (!encontrado) {
            System.out.println("El vinilo no se encuentra en la colección.");
        }
    }

    private void mostrarColeccion() {
        coleccion.mostrarColeccion();
    }

    private void mostrarCantidadVinilos() {
        System.out.println("Cantidad de vinilos en la colección: " + coleccion.getCantidadVinilos());
    }

    private void mostrarEspaciosDisponibles() {
        System.out.println("Espacios disponibles en la colección: " + coleccion.getEspaciosDisponibles());
    }
}
