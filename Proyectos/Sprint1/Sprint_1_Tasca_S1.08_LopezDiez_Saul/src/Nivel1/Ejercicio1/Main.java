package Nivel1.Ejercicio1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> inicial = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();
        inicial.add("Pepe");
        inicial.add("misoginia");
        inicial.add("elucubracion");
        inicial.add("asintomatico");
        inicial.add("realismo");
        inicial.add("Casandra");
        inicial.forEach( (n) -> {
            if (n.contains("n")) {
                resultado.add(n);
            }});
        resultado.forEach( (n) -> { System.out.println(n);});


    }
}
