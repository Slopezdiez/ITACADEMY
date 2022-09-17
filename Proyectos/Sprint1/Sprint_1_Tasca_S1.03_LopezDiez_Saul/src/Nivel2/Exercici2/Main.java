package Nivel2.Exercici2;

import java.util.*;

public class Main {
    static HashSet<Restaurant> restaurants = new HashSet<Restaurant>();


    public static void main(String[] args) {

        Restaurant r1 = new Restaurant("r1", 10);
        Restaurant r2 = new Restaurant("r1", 9);
        Restaurant r3 = new Restaurant("r2", 10);
        Restaurant r4 = new Restaurant("r1", 10);

        añadirRestaurantes(r1);
        añadirRestaurantes(r2);
        añadirRestaurantes(r3);
        añadirRestaurantes(r4);


        List<Restaurant> lista = new ArrayList<>(restaurants);

        Collections.sort(lista, Comparator.comparing(Restaurant::getNom)
                .reversed()
                .thenComparing(Restaurant::getPuntuacio)
                .reversed());


        lista.forEach(x -> System.out.println(x.getNom() + " " + x.getPuntuacio()));
    }

    private static void añadirRestaurantes(Restaurant r1) {
        boolean existe = comprobarSiRestauranteExiste(r1);
        if (existe) {
            System.out.println("Restaurante con esa puntuacion ya existe");
        } else {
            restaurants.add(r1);
            System.out.println("Añadido");

        }
    }

    private static boolean comprobarSiRestauranteExiste(Restaurant r1) {
        for (Restaurant r : restaurants) {
            if (r.getNom().equalsIgnoreCase(r1.getNom()) && r.getPuntuacio() == r1.getPuntuacio()) {
                return true;
            }
        }
        return false;
    }
}
