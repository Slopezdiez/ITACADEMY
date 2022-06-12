package Nivel1.Ejercicio8;

public class Main {

    interface Reverse{
        public String reverse(String s);
    }

    public static void main(String[] args){

        Reverse r= (s) -> {
            StringBuilder st= new StringBuilder(s);
            String invertida= null;
            return invertida= st.reverse().toString();
        };
        System.out.println(r.reverse("123456"));
    }
}
