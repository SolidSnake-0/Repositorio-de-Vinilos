package src;

import java.util.ArrayList;

public class ColeccionVinilos {
    private ArrayList<Vinilo> vinilos;
    private static final int MAX_VINILOS = 100;

    public ColeccionVinilos() {
        this.vinilos = new ArrayList<>();
    }

    public boolean agregarVinilo(Vinilo vinilo) {
        if (vinilos.size() < MAX_VINILOS) {
            vinilos.add(vinilo);
            System.out.println("Vinilo agregado: " + vinilo.getTitulo());
            return true;
        } else {
            System.out.println("No se puede agregar el vinilo. Colección completa.");
            return false;
        }
    }

    public boolean buscarVinilo(String titulo) {
        for (Vinilo vinilo : vinilos) {
            if (vinilo.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Vinilo encontrado: " + vinilo);
                return true;
            }
        }
        System.out.println("Vinilo no encontrado: " + titulo);
        return false;
    }

    public int getCantidadVinilos() {
        return vinilos.size();
    }

    public int getEspaciosDisponibles() {
        return MAX_VINILOS - vinilos.size();
    }

    public void mostrarColeccion() {
        if (vinilos.isEmpty()) {
            System.out.println("La colección está vacía.");
        } else {
            System.out.println("Colección de vinilos:");
            for (Vinilo vinilo : vinilos) {
                System.out.println(vinilo);
            }
        }
    }
}
