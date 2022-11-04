package Nivel2.Ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        String resultado=ejercicio(list);
       System.out.println(resultado);

    }

    private static String ejercicio(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(i -> {
            if(i%2==0){
                sb.append("e"+i+" ,");
            }else{
                sb.append("o"+i+" ,");
            }

        });
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
