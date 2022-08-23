package Nivel3;

public class CambioDolares extends Cambio{
private final String nombre= "Dolares";

    public String getNombre() {
        return nombre;
    }

    double cambio(double dinero){
        return  (dinero*1.0005);
    }
}

