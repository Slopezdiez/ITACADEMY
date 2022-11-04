package Nivel2.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> inicial = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();
        inicial.add("Anapurnio");
        inicial.add("Antonio");
        inicial.add("Andres");
        inicial.add("Juan");
        inicial.add("Anais");
        inicial.add("Julia");
        inicial.add("Saul");

        resultado=nombresConA(inicial);
        resultado.forEach(System.out::println);
    }

    private static ArrayList<String> nombresConA(ArrayList<String> inicial) {
       ArrayList<String> resultado = new ArrayList<>();;
       resultado=inicial.stream().filter(x->x.startsWith("A")).limit(3).collect(Collectors.toCollection(ArrayList::new));


        return resultado ;
    }
}
