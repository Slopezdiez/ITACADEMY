package n1ejercicio2;

public class Coche {

    private static final String marca = "Renault";
    private static String modelo;
    private final int potencia;

    //solo deja inicializar en el constructor la potencia, el final
    public Coche(int potencia) {
        this.potencia = potencia;
    }

    public static void frenar() {
        System.out.println("El vehiculo esta frenando");
    }

    public void acelerar() {
        System.out.println("El vehiculo esta acelerando");
    }
}
