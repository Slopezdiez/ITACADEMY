package n1ejercicio2;

import static entradaDatos.inputsScanner.*;
public class Main {
    public static void main(String[] args){

byte n=llegirByte("h");
       byte numero= llegirByte("Llegir byte");
       System.out.println("Byte introducido: "+ numero);

        int numero1= llegirInt("Llegir int");
        System.out.println("int introducido: "+ numero1);

        float numero2= llegirFloat("Llegir float");
        System.out.println("float introducido: "+ numero2);

        double numero3= llegirDouble("Llegir double");
        System.out.println("double introducido: "+ numero3);

        char a = llegirChar("LLegir char");
        System.out.println("char introducido: "+ a);
        String a1 = llegirString("LLegir String");
        System.out.println("String introducido: "+ a1);

        Boolean a2 = llegirSiNo("S o N");
        System.out.println("Boolean : "+ a2);
    }
    }

