package Nivel1.Ejercicio3;

import java.util.ArrayList;

public class ErrorFueraLimite {
    private ArrayList errorList = new ArrayList();
    private String nombre;

    public ErrorFueraLimite(){
        errorList.add(9,1);
    }
    public ErrorFueraLimite(String nombre){
        this.nombre = nombre;
    }

    public void generarErrorFueraDeLimite(){
        errorList.add(9,1);
    }
}
