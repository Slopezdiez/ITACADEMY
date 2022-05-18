package n1ejercicio1;

public class InstrumentoDePercusion extends Instrumento {

    public InstrumentoDePercusion(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public void tocar() {
        System.out.println("Esta sonando un instrumento de percusion");
    }
}
