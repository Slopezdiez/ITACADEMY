package Nivell1.Exercici1;

public class Main {

    public static void main(String[] args) {

        NoGenericMethods<Integer, Integer, Integer> prueba= new NoGenericMethods<>(1,2,3);
        System.out.println(prueba.getT1()+" "+prueba.getT2()+" "+prueba.getT3());
        NoGenericMethods <String,Integer,String> prueba2= new NoGenericMethods<>("Pepe",2,"Mario");
        System.out.println(prueba2.getT1()+" "+prueba2.getT2()+" "+prueba2.getT3());
    }
}
