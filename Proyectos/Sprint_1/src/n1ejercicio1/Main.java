package n1ejercicio1;

import static n1ejercicio1.Instrumento.iniciarVariableDeClase;

public class Main {
    public static void main(String[] args) {
        //declaramos e instanciamos objetos de cada tipo de Instrumento
        InstrumentoDeViento flauta = new InstrumentoDeViento("Flauta", 10);
        InstrumentoDeCuerda violin = new InstrumentoDeCuerda("Stradivarius", 5000000);
        InstrumentoDePercusion tambor = new InstrumentoDePercusion("tambor", 100);
        //llamamos al mismo metodo que tiene una implementacion diferente en funcion de la clase que sea
        flauta.tocar();
        violin.tocar();
        tambor.tocar();
        //cambiamos la variable estatica de clase
        Instrumento.variableEstatica = iniciarVariableDeClase(1);
        System.out.println(Instrumento.variableEstatica);
    }
}
