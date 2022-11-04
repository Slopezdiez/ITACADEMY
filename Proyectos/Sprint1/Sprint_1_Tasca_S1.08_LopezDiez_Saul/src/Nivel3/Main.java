package Nivel3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList <Alumne> alumnes = new ArrayList();
        alumnes.add(new Alumne("Saul",42,"JAVA",10));
        alumnes.add(new Alumne("Pepe",30,"JAVA",9));
        alumnes.add(new Alumne("Juan",28,"PHP",8));
        alumnes.add(new Alumne("Antonio",72,"PHP",7));
        alumnes.add(new Alumne("Sara",13,"JAVA",6));
        alumnes.add(new Alumne("Alba",55,"JAVA",5));
        alumnes.add(new Alumne("Raquel",36,"PHP",4));
        alumnes.add(new Alumne("Marife",16,"JAVA",3));
        alumnes.add(new Alumne("Ruben",12,"PHP",2));
        alumnes.add(new Alumne("Ximena",99,"PHP",1));

        /*
        //Mostra per pantalla el nom i l’edat de cada alumne/a.
        alumnes.stream().forEach(x->{
            System.out.println(x.getNom()+" "+x.getEdat());
                });
*/
/*

        //Filtra la llista per tots els alumnes que el seu nom comença per ‘a’. Assigna a aquests alumnes a una altra  llista i  mostra per pantalla la nova llista (tot  amb lambdes).
        ArrayList <Alumne> alumnesOrdenats = new ArrayList();
        alumnesOrdenats=alumnes.stream().filter(x->x.getNom().toLowerCase().startsWith("a")).collect(Collectors.toCollection(ArrayList::new));
        alumnesOrdenats.forEach(System.out::println);
*/
/*

        //Filtra i mostra per pantalla els alumnes que tenen una nota de 5 o superior.
        alumnes.stream().filter(x->x.getNota()>=5).forEach(System.out::println);
*/
/*
        //Filtra i mostra per pantalla els alumnes que tenen un nota de 5 o més, i que no són de PHP.
        alumnes.stream().filter(x->x.getNota()>=5).filter(x->!x.getCurs().equalsIgnoreCase("PHP")).forEach(System.out::println);
        */

        //Mostra tots els alumnes que fan JAVA i són majors d’edat.
        alumnes.stream().filter(x->x.getEdat()>=18).filter(x->x.getCurs().equalsIgnoreCase("JAVA")).forEach(System.out::println);

    }
}
