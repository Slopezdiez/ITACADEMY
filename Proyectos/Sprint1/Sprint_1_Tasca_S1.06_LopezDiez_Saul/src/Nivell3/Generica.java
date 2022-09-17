package Nivell3;

public class Generica {
    public static<T extends Telefon> void metodoGenericoTelefon (T telefon){

        telefon.trucar();
        //telefon.ferFotos();
    }
    public static<T extends Smartphone> void metodoGenericoSmartphone (T smartphone){

        smartphone.trucar();
        smartphone.ferFotos();
    }
}
