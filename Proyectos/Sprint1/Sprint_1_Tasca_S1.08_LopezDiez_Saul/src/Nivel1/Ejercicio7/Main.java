package Nivel1.Ejercicio7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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

        Collections.sort(resultado,Collections.reverseOrder( Comparator.comparing(String::length)));
        System.out.println(resultado);
    }
}
