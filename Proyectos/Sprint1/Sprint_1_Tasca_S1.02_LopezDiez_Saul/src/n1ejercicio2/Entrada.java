package n1ejercicio2;

public class Entrada extends Exception {
/*    static Scanner sc = new Scanner(System.in);


    public static byte llegirByte(String missatge) {

        System.out.println(missatge);
        try {
            if (!sc.hasNextByte()) {
                sc.nextLine();
                throw new InputMismatchException();
            } else {
                byte input = sc.nextByte();
                return input;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de tipo, introduce el tipo correcto: " + e.getMessage());
            return llegirByte(missatge);
        }

    }


    public static int llegirInt(String missatge) {
        System.out.println(missatge);
        try {
            if (!sc.hasNextInt()) {
                sc.nextLine();
                throw new InputMismatchException();
            } else {
                int input = sc.nextInt();
                return input;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de tipo, introduce el tipo correcto: " + e.getMessage());
            return llegirInt(missatge);
        }

    }

    public static float llegirFloat(String missatge) {
        System.out.println(missatge);
        try {
            if (!sc.hasNextFloat()) {
                sc.nextLine();
                throw new InputMismatchException();
            } else {
                float input = sc.nextFloat();
                return input;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de tipo, introduce el tipo correcto: " + e.getMessage());
            return llegirInt(missatge);
        }
    }

    public static double llegirDouble(String missatge) {
        System.out.println(missatge);
        try {
            if (!sc.hasNextDouble()) {
                sc.nextLine();
                throw new InputMismatchException();
            } else {
                double input = sc.nextDouble();
                return input;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de tipo, introduce el tipo correcto: " + e.getMessage());
            return llegirInt(missatge);
        }
    }

    public static char llegirChar(String missatge) {
        System.out.println(missatge);
        char input = 0;
        while (input == 0) {
            try {
                input = sc.next("[a-zA-Z]").charAt(0);
            } catch (Exception e) {
                System.out.println("Error de tipo, introduce el tipo correcto: " + e.getMessage());
                System.out.println(missatge);
            }
            sc.nextLine();
        }
        return input;
    }

    public static String llegirString(String missatge) {
        System.out.println(missatge);
        String input = null;
        while (input == null) {
            try {
                if (sc.hasNext("[A-Za-z]*")) {
                    input = sc.next();
                } else {
                    throw new InputMismatchException();
                }
            } catch (Exception e) {
                System.out.println("Error de tipo, introduce el tipo correcto: " + e.getMessage());
                System.out.println(missatge);
            }
            sc.nextLine();
        }
        return input;
    }

    public static boolean llegirSiNo(String missatge) {
        System.out.println(missatge);
        Boolean input = null;
        String q = null;
        while (input == null) {
            try {
                q = String.valueOf(llegirChar("Decide:"));
                if (q.equalsIgnoreCase("s")) {
                    input = true;
                } else if (q.equalsIgnoreCase("n")) {
                    input = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error! introduce S o N: ");
            }
        }
        return input;
    }*/

}
