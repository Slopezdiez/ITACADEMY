package n1ejercicio1;

public class ExcepcionPersonalizada extends Exception{

    public ExcepcionPersonalizada(String mensaje){
        super(mensaje);
        System.out.println(mensaje);
    }
}
