package n1ejercicio3;

import java.util.*;

public class Cine {

    private int nombreFiles, nombreSeients;
    GestioButaques gestioButaques;

    public Cine() {
        this.gestioButaques = new GestioButaques(new ArrayList<Butaca>());
        demanarDadesInicials();
    }

    public void iniciar() {
        boolean exit = false;
        do {
            switch (printMainMenu()) {
                case 1:
                    mostrarButaques();
                    break;
                case 2:
                    mostrarButaquesPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar la aplicación");
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private void anularReservaPersona() {
        String nombre = introduirPersona();
        //gestioButaques.getButaques().removeIf(x->x.getPersona().contains(nombre));

        Iterator<Butaca> it = gestioButaques.getButaques().iterator();
        //int[] m= new int[2];
        ArrayList<Integer> m = new ArrayList<>();
        try {
            while (it.hasNext()) {
                Butaca b = it.next();
                if (b.getPersona().equalsIgnoreCase(nombre)) {
                    m.add(b.getNombreFila());
                    m.add(b.getNombreSeient());
                }
            }
            for (int i = 0; i < m.size(); i++) {
                int fila =  m.get(i);
                int seient =  m.get(i + 1);
                i++;
                gestioButaques.eliminaButaca(fila, seient);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e.getMessage());
        }
    }

    private void anularReserva() {
        int fila = introduirFila();
        int seient = introduirSeient();
        gestioButaques.eliminaButaca(fila, seient);
    }

    private void reservarButaca() {

        int fila = introduirFila();
        int seient = introduirSeient();
        String nombre = introduirPersona();
        Butaca butaca = new Butaca(fila, seient, nombre);
        gestioButaques.afegirButaca(butaca);
    }

    private void mostrarButaquesPersona() {
        String persona = entradaDatos.inputsScanner.llegirString("Nom");
        this.gestioButaques.getButaques().forEach(x -> {
            if (x.getPersona().equals(persona)) {
                System.out.println(x);
            }
        });
    }

    private void mostrarButaques() {
        this.gestioButaques.getButaques().forEach(System.out::println);
    }

    private String introduirPersona() {
        String nombre = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nom de persona?");

            if (scanner.hasNextLine()) {
                nombre = scanner.nextLine();
            } else {
                throw new ExcepcioNomPersonaIncorrecte();
            }
        } catch (ExcepcioNomPersonaIncorrecte e) {
            System.out.println("Error nom incorrecte: " + e.getMessage());
        }
        return nombre;
    }

    private int introduirFila() {
        int fila = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Fila?");

            if (scanner.hasNextInt()) {
                fila = scanner.nextInt();
            } else {
                throw new ExcepcioFilaIncorrecta();
            }
        } catch (ExcepcioFilaIncorrecta e) {
            System.out.println("Error fila incorrecte: " + e.getMessage());
        }
        return fila;
    }

    private int introduirSeient() {
        int seient = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seient?");

            if (scanner.hasNextInt()) {
                seient = scanner.nextInt();
            } else {
                throw new ExcepcioSeientIncorrecte();
            }
        } catch (ExcepcioSeientIncorrecte e) {
            System.out.println("Error seient incorrecte: " + e.getMessage());
        }
        return seient;
    }

    public static byte printMainMenu() {

        Scanner sc = new Scanner(System.in);
        byte option;
        final byte MIN = 0;
        final byte MAX = 6;

        do {
            System.out.println("**************************************************");
            System.out.println("*                 Menú principal                 *");
            System.out.println("**************************************************");
            System.out.println();
            System.out.println("1  -  Mostrar totes les butaques reservades.");
            System.out.println("2  -  Mostrar les butaques reservades per una persona.");
            System.out.println("3  -  Reservar una butaca");
            System.out.println("4  -  Anul·lar la reserva d?una butaca.");
            System.out.println("5  -  Anul·lar totes les reserves d?una persona.");
            System.out.println(" 0 -  Salir");

            option = sc.nextByte();
            if (option < MIN || option > MAX) {
                System.out.println("Escoge una opción válida");
            }
        } while (option < MIN || option > MAX);
        return option;

    }

    private void demanarDadesInicials() {
        this.nombreFiles = introduirFila();
        this.nombreSeients = introduirSeient();

    }
}
