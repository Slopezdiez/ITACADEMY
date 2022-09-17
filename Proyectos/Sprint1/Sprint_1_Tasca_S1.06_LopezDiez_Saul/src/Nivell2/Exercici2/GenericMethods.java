package Nivell2.Exercici2;

public class GenericMethods{

 //public static<T1,T2,T3> void verObjetos (T1 t1, T2 t2, T3 t3){
 public static<T1,T2,T3> void verObjetos (T1 ... v){

     T1 t1 = (T1)v[0];
     T2 t2 = (T2)v[1];
     T3 t3 = (T3)v[2];

     System.out.println(t1+" "+t2+" "+t3);
 }
    public static<T> void verObjetos2 (T ... v){
        for (int i = 0; i <v.length ; i++) {
            System.out.println(v[i]);
        }
    }
}
