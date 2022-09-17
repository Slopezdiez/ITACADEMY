package Nivel3;
//import UtilidadesSLD.*;
public class Main {
    public static void main(String[] args) {

        boolean sortir = false;

        do{
            switch( UtilidadesSLD.Menu.Menu()){
                case 1: leerArchivosyDirectorios();
                    break;
                case 2: guardarInformacionEnArchivo();
                    break;
                case 3: leerArchivo();
                    break;
                case 0: System.out.println("Gràcies per utilitzar l'aplicació");
                    sortir = true;
                    break;
            }
        }while(!sortir);
    }
}
