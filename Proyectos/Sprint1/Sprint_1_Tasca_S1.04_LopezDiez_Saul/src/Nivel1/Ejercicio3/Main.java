package Nivel1.Ejercicio3;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Main {

    public static void main(String[] args){
        //ErrorFueraLimite e=new ErrorFueraLimite();
        ErrorFueraLimite e=new ErrorFueraLimite("error");
        Exception exception=assertThrows(IndexOutOfBoundsException.class, () -> {e.generarErrorFueraDeLimite();});
        exception.printStackTrace();
        System.out.println(exception.getLocalizedMessage());
        System.out.println(exception.getCause());
        System.out.println(exception.toString());
        System.out.println(exception.getClass());
        System.out.println(exception.getMessage());
    }
}
