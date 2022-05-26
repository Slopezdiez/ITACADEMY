package Nivel1.Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){

        ArrayList<Month> mesos = new ArrayList<Month>();
        mesos.add(new Month("Gener"));
        mesos.add(new Month("Febrer"));
        mesos.add(new Month("Març"));
        mesos.add(new Month("Abril"));
        mesos.add(new Month("Maig"));
        mesos.add(new Month("Juny"));
        mesos.add(new Month("Juliol"));
        mesos.add(new Month("Setembre"));
        mesos.add(new Month("Octubre"));
        mesos.add(new Month("Novembre"));
        mesos.add(new Month("Desembre"));
        System.out.println("Se crean los meses y se añaden al Arraylist excepto Agosto");
        System.out.println(mesos);
        System.out.println("Se añade en su posicion Agosto");
        mesos.add(7,new Month("Agost"));
        System.out.println(mesos);
        System.out.println("Diferentes formas de crear un HashSet. Primero con su metodo cogiendo el ArrayList directamente");
        HashSet<Month> hashSetdirecto= new HashSet<>();
        hashSetdirecto.addAll(mesos);
        System.out.println(hashSetdirecto);
        System.out.println("Segundo con un for");
        HashSet<Month> hashSetFor= new HashSet<>();
        for (Month m: mesos){
            hashSetFor.add(m);
        }
        System.out.println(hashSetFor);
        System.out.println("Tercero con un iterador y un while");
        HashSet<Month> hashSet= new HashSet<>();
        Iterator<Month> iter= mesos.iterator();
        while (iter.hasNext()){
            hashSet.add(iter.next());
        }
        System.out.println(hashSet);
        System.out.println("Intentamos añadir todo el listado otra vez y vemos como no permite duplicados");
        hashSet.addAll(mesos);
        System.out.println(hashSet);
        System.out.println("Nos inventamos un mes y lo intentamos añadir dos veces y vemos como no permite duplicados");
        Month duplicado= new Month("inventado");
        hashSet.add(duplicado);
        hashSet.add(duplicado);
        System.out.println(hashSet);
    }
}
