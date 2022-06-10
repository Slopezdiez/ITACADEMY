package Nivel1.Ejercicio1;

public class Main {

    public static void main(String[] args) {
        Treballador treballador = new Treballador("pepe","gotera",10);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Casero", "casa",11,20);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Presencial", "Esquirol",9,50);
        System.out.println(" El sou del Treballador es: "+treballador.calcualrSou(10));
        System.out.println(" El sou del Treballador  Online es: "+treballadorOnline.calcualrSou(10));
        System.out.println(" El sou del Treballador Presencial es: "+treballadorPresencial.calcualrSou(10));


    }
}
