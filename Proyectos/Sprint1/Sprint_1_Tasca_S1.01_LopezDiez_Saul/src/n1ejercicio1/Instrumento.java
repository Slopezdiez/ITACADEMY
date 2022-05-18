package n1ejercicio1;

public abstract class Instrumento {

    //podemos crear un metodo estatico, si qeueremos reusar para reiniciar la variable de clase
    public static String variableEstatica = iniciarVariableDeClase(0);
    private String nombre;
    private int precio;

    public Instrumento(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //podemos hacer un bloque estatico que carga la primera vez que carga la clase
   /* static {
        System.out.println("Bloque de inicializacion, ocurre sólo una vez");
    }*/

    protected static String iniciarVariableDeClase(int decision) {

        String mensaje = null;
        if (decision == 0) {
            mensaje = "Bloque de inicializacion, ocurre solo una vez, al cargar la clase";
            System.out.println("Bloque de inicializacion, ocurre solo una vez, al cargar la clase");
        } else {
            mensaje = "Cambiamos el bloque de inicializacion";
        }

        return mensaje;
    }

    public abstract void tocar();
}
