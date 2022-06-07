package Nivell1.Exercici2;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("Pepe", "Gomez",33);
        GenericMethods.verObjetos(persona,"probando",3);
        GenericMethods.verObjetos("Datos del alumno:\n",persona,"\n *****************************");

    }
}
