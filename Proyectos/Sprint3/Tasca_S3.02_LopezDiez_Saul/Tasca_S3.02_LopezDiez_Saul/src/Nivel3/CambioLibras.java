package Nivel3;

public class CambioLibras extends Cambio{
    private final String nombre= "Libras";

    public String getNombre() {
        return nombre;
    }

    double cambio(double dinero){
        return (dinero*0.84278);
    }
}
