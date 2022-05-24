package n1ejercicio1;

public class VendaBuidaException extends Exception{

    public VendaBuidaException(String mensaje){
        super(mensaje);
        System.out.println(mensaje);
    }
}
