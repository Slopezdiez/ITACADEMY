package Nivel1.Ejercicio4;

import java.util.ArrayList;

public class Main {

    public static void imprimir(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        ArrayList<String> meses = new ArrayList<>();

        meses.add("enero");
        meses.add("febrero");
        meses.add("marzo");
        meses.add("abril");
        meses.add("mayo");
        meses.add("junio");
        meses.add("julio");
        meses.add("agosto");
        meses.add("septiembre");
        meses.add("octubre");
        meses.add("noviembre");
        meses.add("diciembre");


        meses.forEach(Main::imprimir);
        meses.stream().map(String::valueOf).forEach(System.out::println);


    }
}
