package Nivel2.Ejercicio3;

public class Main {

    interface miInterfaceFuncional{
        public float operacio(String s, float x, float y);
    }


    public static void main(String[] args) {
    miInterfaceFuncional m= (f,x,y)->{
        float result = 0;
        switch(f){
           // case f.equalsIgnoreCase("suma")-> result= x+y;
            case "suma"-> result= x+y;
            case "resta"-> result= x-y;
            case "multiplicacion"-> result= x*y;
            case "division"-> result= x/y;
        }
        return result;
    };

        System.out.println(m.operacio("suma",6,2));
        System.out.println(m.operacio("resta",6,2));
        System.out.println(m.operacio("multiplicacion",6,2));
        System.out.println(m.operacio("division",6,2));
    }
}
