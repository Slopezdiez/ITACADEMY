package Nivel3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Properties;


public class Main {
    static Properties properties= new Properties();
    public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {

        //Properties properties= new Properties();
        properties.load(new FileInputStream(new File("src/Nivel3/configuracion2.properties")));

        File dir = new File(properties.getProperty("Directorio"));
        //File dir = new File(args[0]);

        //System.out.println("Listando archivos y directorios " + dir.getCanonicalPath() + " indicando si es fichero o directorio y fecha de ultima modiifcacion");
        System.out.println("Listando archivos y directorios " + dir+ " indicando si es fichero o directorio y fecha de ultima modiifcacion");


        Iterator<File> fileIterator = FileUtils.iterateFiles(dir, TrueFileFilter.INSTANCE, null);

        fileIterator = FileUtils.iterateFilesAndDirs(dir, TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE);
        StringBuilder sb = new StringBuilder();
        while(fileIterator.hasNext()){
            File file = fileIterator.next();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            String modificado=(sdf. format(file. lastModified()));

            String mensaje=null;
            if(file.isDirectory()){
                mensaje=("D-- "+ file+" ---- Ultima modificacion: "+modificado);

            }
            if(file.isFile()){
                mensaje=("F---- "+ file+" ---- Ultima modificacion: "+modificado);
            }
            sb.append(mensaje+"\n");
        }


        guardarInformacionEnArchivo(sb.toString());

        SecretKey secretKey = EncriptadoUtils.keygenKeyGeneration(256);

        //File encryption
        File readFile = new File(properties.getProperty("DirectorioGuardar"), properties.getProperty("NombreArchivo"));
        File encryptedFile = new File(properties.getProperty("DirectorioGuardar"), properties.getProperty("NombreArchivoEncriptado"));
        try {
            EncriptadoUtils.encryptFile(secretKey, readFile, encryptedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File decryption
        File readEncryptedFile = new File(properties.getProperty("DirectorioGuardar"), properties.getProperty("NombreArchivoEncriptado"));
        File decryptedFile = new File(properties.getProperty("DirectorioGuardar"), properties.getProperty("NombreArchivoDesencriptado"));
        try {
            EncriptadoUtils.decryptFile(secretKey, readEncryptedFile, decryptedFile);
        } catch (IOException | BadPaddingException e) {
            e.printStackTrace();
        }


    }

    private static void guardarInformacionEnArchivo(String informacion) {
        try {
            String ruta = properties.getProperty("DirectorioGuardar")+"\\"+properties.getProperty("NombreArchivo");
            //String ruta = "d:\\testing123\\Informacion.txt";
            //String contenido = "El usuario "+usuario+" ha obtenido una puntuacion de "+puntuacion+"\n";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(informacion);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
