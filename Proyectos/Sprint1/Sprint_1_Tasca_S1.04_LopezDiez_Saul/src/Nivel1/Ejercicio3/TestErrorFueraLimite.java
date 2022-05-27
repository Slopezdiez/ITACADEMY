package Nivel1.Ejercicio3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestErrorFueraLimite {
    @Test
     void fueraLimite(){

        try {
            ErrorFueraLimite e=new ErrorFueraLimite();
        }catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }catch(Exception e){
            fail("excepcion erronea");
        }
    }

    @Test
    void errorFueraLimiteConMetodo(){
        ErrorFueraLimite e=new ErrorFueraLimite("error");
        Exception exception=assertThrows(IndexOutOfBoundsException.class, () -> {e.generarErrorFueraDeLimite();});
        String expectedMessage = "class java.lang.IndexOutOfBoundsException";
        String actualMessage = String.valueOf(exception.getClass());

        assertTrue(actualMessage.contains(expectedMessage));

    }
}
