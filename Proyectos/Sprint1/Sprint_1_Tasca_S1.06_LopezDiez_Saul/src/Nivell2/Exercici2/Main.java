package Nivell2.Exercici2;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("Pepe", "Gomez",33);
/*
        GenericMethods.verObjetos(persona,"probando",3);
        GenericMethods.verObjetos("Datos del alumno:\n",persona,"\n *****************************");

        GenericMethods.verObjetos(persona,"probando",3,4);
*/

        GenericMethods.verObjetos2(persona,"probando",3,4, "cha cha cha");
    }
}
