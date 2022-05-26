package Nivel1.Ejercicio2;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(i);
            System.out.println("Añadido el numero "+i);
        }
        System.out.println("La primera lista contiene: "+list);

        List<Integer> list2 = new ArrayList<>();
        ListIterator <Integer> it = list.listIterator();
        int numero =0;

        while (it.hasNext()){
            it.next();
        }
        while (it.hasPrevious()) {
            numero = it.previous();
            list2.add(numero);
            System.out.println("Añadido a la segunda lista en orden inverso: "+ numero);
        }
        System.out.println("La segunda lista contiene: "+list2);
        System.out.println("La primera lista contiene: "+list);


    }
}
