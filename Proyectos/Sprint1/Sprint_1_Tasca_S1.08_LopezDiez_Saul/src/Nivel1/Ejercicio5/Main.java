package Nivel1.Ejercicio5;

public class Main {

    interface MetodoPi{
        public double getPiValue();
    }

    public static void main(String[] args){

        MetodoPi pi= () -> 3.1416;
        System.out.println(pi.getPiValue());
    }
}
