package n1ejercicio2;

public class Main {

    public static void main(String[] args) {

        Coche.frenar();//al ser estatico, podemos invocar el metodo estatico sin instanciar
        //Coche.acelerar(); Sin embargo el metodo que no es estatico no podemos invocarlo
        Coche coche1 = new Coche(100);//instanciamos coche
        coche1.acelerar();//desde el objeto instanciado podemos llaar los dos metodos.
        coche1.frenar();
    }
}
