package n1ejercicio1;

public class InstrumentoDeCuerda extends Instrumento {

    public InstrumentoDeCuerda(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public void tocar() {
        System.out.println("Esta sonando un instrumento de cuerda");
    }
}
