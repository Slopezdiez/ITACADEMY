package Nivel1.Ejercicio5;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        boolean sortir = false;

        do{
            switch(menu()){
                case 1: leerArchivosyDirectorios();
                    break;
                case 2: guardarInformacionEnArchivo();
                    break;
                case 3: leerArchivo();
                    break;
                case 4: serializar();
                    break;
                case 5: deserializar();
                    break;
                case 0: System.out.println("Gràcies per utilitzar l'aplicació");
                    sortir = true;
                    break;
            }
        }while(!sortir);




    }


    public static byte menu(){
        Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 5;

        do{
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Ver directorios.");
            System.out.println("2. Guardar en archivo informacion de directorios y archivos.");
            System.out.println("3. Leer archivo.");
            System.out.println("4. Serializar un objeto.");
            System.out.println("5. Deserializar un objeto.");
            System.out.println("0. Sortir de l'aplicació.\n");
            opcio = entrada.nextByte();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Escull una opció vàlida");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }




    public static String leerArchivosyDirectorios() throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Elige la ruta ");
        String ruta= entrada.nextLine();
        File dir = new File(ruta);


        System.out.println("Listando archivos y directorios " + dir.getCanonicalPath() + " indicando si es fichero o directorio y fecha de ultima modiifcacion");


        Iterator<File> fileIterator = FileUtils.iterateFiles(dir, TrueFileFilter.INSTANCE, null);

        fileIterator = FileUtils.iterateFilesAndDirs(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        StringBuilder sb = new StringBuilder();
        while (fileIterator.hasNext()) {
            File file = fileIterator.next();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            String modificado = (sdf.format(file.lastModified()));

            String mensaje = null;
            if (file.isDirectory()) {
                mensaje = ("D-- " + file + " ---- Ultima modificacion: " + modificado);
                System.out.println("D-- "+ file+" ---- Ultima modificacion: "+modificado);
            }
            if (file.isFile()) {
                mensaje = ("F---- " + file + " ---- Ultima modificacion: " + modificado);
                System.out.println("F---- "+ file+" ---- Ultima modificacion: "+modificado);
            }
            sb.append(mensaje + "\n");
        }
        return sb.toString();
    }


    public static void guardarInformacionEnArchivo() {
        try {
            String informacion=leerArchivosyDirectorios();
            Scanner entrada = new Scanner(System.in);
            System.out.println("Elige la ruta y nombre del archivo");
            String ruta= entrada.nextLine();
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(informacion);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void leerArchivo() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Elige la ruta y nombre del archivo");
        String ruta= entrada.nextLine();

        BufferedReader br = null;

        try {

            // creamos el objeto Archivo
            File file = new File(ruta);

            // creamo un buffer desde el archivo
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // leemos liena a linea
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // cerramos el buffer
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
                ;
            }
        }

    }


    private static void deserializar() {
        PruebaSerializar prueba=null;
        try
        {
            FileInputStream archivo = new
                    FileInputStream("prueba.ser");
            ObjectInputStream entrada = new
                    ObjectInputStream(archivo);
            prueba = (PruebaSerializar) entrada.readObject();
            entrada.close();
            archivo.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
            return;
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Clase PruebaSerializar no encontrada");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserializando al empleado...");
        System.out.println("Nombre: " + prueba.getNombre());
        System.out.println("Numero: " + prueba.getNumero());

    }

    private static void serializar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Elige el nombre");
        String nombre=entrada.nextLine();
        System.out.println("Elige el numero");
        int numero= Integer.parseInt(entrada.nextLine());
        PruebaSerializar prueba = new PruebaSerializar(nombre,numero);
        try
        {
            FileOutputStream archivo = new
                    FileOutputStream("prueba.ser");
            ObjectOutputStream salida = new
                    ObjectOutputStream(archivo);
            salida.writeObject(prueba);
            salida.close();
            archivo.close();
            System.out.println("Datos guardados en prueba.ser");
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
}
