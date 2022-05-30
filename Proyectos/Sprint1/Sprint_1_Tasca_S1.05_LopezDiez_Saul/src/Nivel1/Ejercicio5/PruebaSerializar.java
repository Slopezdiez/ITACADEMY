package Nivel1.Ejercicio5;

import java.io.Serializable;

public class PruebaSerializar implements Serializable {

    private String nombre;
    private int numero;

    public PruebaSerializar(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
