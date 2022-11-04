package Nivel2.Ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;



public class Main {

    public static void main(String[] args) {
        ArrayList s=new ArrayList<>();
        ArrayList <String> resultado =new ArrayList<>();

        s.add(1);
        s.add("antonio");
        s.add(2);
        s.add(3);
        s.add("belen");
        s.add("carlos");
        s.add("elena");
        s.add("eduardo");



        s.stream().forEach(x->{
            resultado.add(x.toString());
        });

        //Alfabèticament pel primer caràcter. (Nota: charAt(0) retorna el codi numèric del primer  caràcter)
        resultado.stream().sorted().forEach(System.out::println);

    /*    Set<Character> priority = Set.of ('e');
        //Comparator<String> pc = Comparator.comparing(m -> m.isEmpty() || !priority.contains(s.charAt(0)));
        Comparator<String> pc = Comparator.comparing(m -> m.isEmpty() || !priority.contains(m.charAt(0)));
        Comparator<String> chained = pc.thenComparing(Comparator.naturalOrder());
        resultado.sort(chained);
        resultado.forEach(System.out::println);*/

        //Les cadenes que contenen una "e" primer, la resta de cadenes després. Posa el codi directament a la lambda.
       resultado.stream().sorted(Comparator.comparing(x->!x.startsWith("e"))).forEach(System.out::println);


        resultado.stream().forEach(x->x.replace("a","4"));
        resultado.forEach(System.out::println);


        //Modifica tots els elements de la llista que tenen una ‘a’. Modifica la ‘a’ per un ‘4’.
        ArrayList<String> resultado2=new ArrayList<String>();
        resultado.stream().forEach(x->{
           //ArrayList<Character> c=x.toCharArray();
            char[] c=x.toCharArray();
            StringBuilder str=new StringBuilder();
            for(int i=0; i<c.length;i++){
                if(c[i] == Character.valueOf('a')){
                    str.append("4");
                }else{
                    str.append(c[i]);
                }

            }
            resultado2.add(str.toString());
        });
        resultado2.forEach(System.out::println);


        //Mostra només els elements que són numèrics. (Encara que estiguin guardats com Strings).
        resultado.stream().forEach(x->{
            if(x.matches("[0-9]")){
                System.out.println(x);
            }
        });
    }
}
