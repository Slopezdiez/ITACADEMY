package Nivel3;

import javax.crypto.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncriptadoUtils {
    public static SecretKey keygenKeyGeneration(int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(keySize);
                sKey = kgen.generateKey();
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible.");
            }
        }
        return sKey;
    }

    public static void encryptFile(SecretKey sKey, File file, File destinationFile) throws IOException {
        byte[] encryptedData = null;
        byte[] data = Files.readAllBytes(file.toPath());
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            fos.write(encryptedData);
            fos.close();
        } catch (NoSuchPaddingException | BadPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 NoSuchAlgorithmException e) {
            System.err.println("Error cifrando los datos: " + e);
        }
    }

    public static void decryptFile(SecretKey sKey, File file, File destinationFile) throws BadPaddingException, IOException {
        byte[] decryptedData = null;
        byte[] data = Files.readAllBytes(file.toPath());
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            decryptedData = cipher.doFinal(data);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            fos.write(decryptedData);
            fos.close();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException |
                 InvalidKeyException e) {
            System.err.println("Error descifrando los datos: " + e);
        }
    }
}
