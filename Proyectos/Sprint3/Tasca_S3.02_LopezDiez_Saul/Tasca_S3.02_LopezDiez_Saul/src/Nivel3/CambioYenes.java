package Nivel3;

public class CambioYenes extends Cambio{
    private final String nombre= "Yenes";

    public String getNombre() {
        return nombre;
    }

    double cambio(double dinero){
        return  (dinero*136.2);
    }
}
