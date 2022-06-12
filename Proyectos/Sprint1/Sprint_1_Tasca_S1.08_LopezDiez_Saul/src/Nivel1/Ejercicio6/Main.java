package Nivel1.Ejercicio6;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        ArrayList s=new ArrayList<>();
        ArrayList <String> resultado =new ArrayList<>();

        s.add(1);
        s.add("hermenegildo");
        s.add(2);
        s.add(3);
        s.add("francisco");
        s.add("luis");

        s.forEach( (n) -> {
            if (n.getClass().getSimpleName().equalsIgnoreCase("String")){
              resultado.add((String) n);
        }
        });

        Collections.sort(resultado, Comparator.comparing(String::length));
        System.out.println(resultado);


    }
}
