package Nivel1.Ejercicio2;

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
        inicial.add("no");
        inicial.forEach( (n) -> {
            if (n.length()>5) {
                if (n.contains("n")) {
                    resultado.add(n);
                }
            }});
        resultado.forEach( (n) -> { System.out.println(n);});
    }
}
