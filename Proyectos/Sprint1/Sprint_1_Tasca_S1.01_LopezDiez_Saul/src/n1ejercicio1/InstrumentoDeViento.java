package n1ejercicio1;

public class InstrumentoDeViento extends Instrumento {

    public InstrumentoDeViento(String nombre, int precio) {
        super(nombre, precio);
    }


    @Override
    public void tocar() {
        System.out.println("Esta sonando un instrumento de viento");
    }
}
