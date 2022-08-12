package NIvel1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String comando = null;
    static ArrayList<Undo> undos = new ArrayList<Undo>();

    public static void main(String[] args) {

        boolean salir = false;

        do {

            switch (menu()) {
                case 1:
                    abrirUndo();
                    break;
                case 2:
                    añadirComando(undos.get(undos.size()-1));
                    break;

                case 3:
                    borrarComando(undos.get(undos.size()-1));
                    break;

                case 4:
                    listarComando(undos.get(undos.size()-1));
                    break;
                case 0:
                    System.out.println("Gracias por utilizar la aplicación");
                    salir = true;
                    break;
            }
        } while (!salir);
    }


    public static byte menu() {
        Scanner entrada = new Scanner(System.in);
        byte opcion;
        final byte MINIMO = 0;
        final byte MAXIMO = 4;

        do {
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Acceso a Undo.");
            System.out.println("2. Añadir comando");
            System.out.println("3. Borrar comando.");
            System.out.println("4. Listar comandos");
            System.out.println("0. Salir de la aplicación.\n");
            opcion = entrada.nextByte();
            if (opcion < MINIMO || opcion > MAXIMO) {
                System.out.println("Escoge una opción valida");
            }
        } while (opcion < MINIMO || opcion > MAXIMO);
        return opcion;
    }


    private static void abrirUndo() {
        Undo u = Undo.getInstancia();
        System.out.println("Conseguida sesion numero  "+ undos.size() + "  Identificador " + u);
        undos.add(u);
    }

    private static void listarComando(Undo u) {
        System.out.println("Se lista comandos");
        u.getComando().forEach(value -> System.out.println(value));

    }

    private static void borrarComando(Undo u) {
        System.out.println("Se borra ultimo comando");
        u.quitarComando();
    }

    private static void añadirComando(Undo u) {
        System.out.println("Comando?");
        comando = scan.nextLine();
        u.añadirComando(comando);

    }

}


