package Nivel1.Ejercicio2;

public class Main {

    public static void main(String[] args){
        CalculoDni s= new CalculoDni(39378289);
        System.out.println(s.getLetra());


         final CalculoDni dni1=new CalculoDni(39378289);
         final CalculoDni dni2=new CalculoDni(12345678);
         final CalculoDni dni3=new CalculoDni(91234567);
         final CalculoDni dni4=new CalculoDni(89123456);
         final CalculoDni dni5=new CalculoDni(78912345);
         final CalculoDni dni6=new CalculoDni(67891234);
         final CalculoDni dni7=new CalculoDni(56789123);
         final CalculoDni dni8=new CalculoDni(45678912);
         final CalculoDni dni9=new CalculoDni(34567891);
         final CalculoDni dni10=new CalculoDni(23456789);
         final CalculoDni[] dni= {dni1,dni2,dni3,dni4,dni5,dni6,dni7,dni8,dni9,dni10};
        for (CalculoDni d : dni) {
            System.out.println(d.getLetra());
        }
        
    }
}
