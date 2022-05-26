package Nivel1.Ejercicio3;
import java.io.*;
import java.util.*;

public class Main {
    final static String filePath
            = "Countries.txt";


    public static void main(String[] args){

        // leemos el archivo y creamos un Hashmap
        HashMap<String, String> paises= HashMapFromTextFile();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario:");
        String usuario=in.nextLine();
        String pregunta=null;
        String respuesta=null;
        String correcta=null;
        int puntuacion=0;
        int intentos=0;
        int aleatorio=0;
        List<String> keys= new ArrayList<>(paises.keySet());//creamos un array de claves para escoger la aleatoria
        while(intentos<10){//10 intentos
            aleatorio=new Random().nextInt(keys.size());
            pregunta= keys.get(aleatorio);
            correcta=paises.get(pregunta);
            System.out.println("La capital de "+ pregunta+ " es:");
            respuesta=in.nextLine();
            if(respuesta.equalsIgnoreCase(correcta)){
                puntuacion++;
            }
            intentos++;
        }
        System.out.println("La puntuacion es "+ puntuacion);
        guardarPuntuacionEnArchivo(usuario,puntuacion);

    }

    private static void guardarPuntuacionEnArchivo(String usuario, int puntuacion) {
        try {
            String ruta = "Puntuacion.txt";
            String contenido = "El usuario "+usuario+" ha obtenido una puntuacion de "+puntuacion+"\n";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static HashMap<String, String> HashMapFromTextFile()
    {

        HashMap<String, String> map
                = new HashMap<>();
        BufferedReader br = null;

        try {

            // creamos el objeto Archivo
            File file = new File(filePath);

            // creamo un buffer desde el archivo
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // leemos liena a linea
            while ((line = br.readLine()) != null) {

                // separamos por espacios
                String[] parts = line.split(" ");

                // primero es el pais  y el segundo la capital
                String pais = parts[0].trim();
                String capital = parts[1].trim();

                // si no esta vacio, añadimos al mapa
                if (!pais.equals("") && !capital.equals(""))
                    map.put(pais, capital);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            // cerramos el buffer
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }

        return map;
    }
}
