package Nivel1.Ejercicio2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculoDni {

    private final CalculoDni dni1=new CalculoDni(39378289);
    private final CalculoDni dni2=new CalculoDni(12345678);
    private final CalculoDni dni3=new CalculoDni(91234567);
    private final CalculoDni dni4=new CalculoDni(89123456);
    private final CalculoDni dni5=new CalculoDni(78912345);
    private final CalculoDni dni6=new CalculoDni(67891234);
    private final CalculoDni dni7=new CalculoDni(56789123);
    private final CalculoDni dni8=new CalculoDni(45678912);
    private final CalculoDni dni9=new CalculoDni(34567891);
    private final CalculoDni dni10=new CalculoDni(23456789);
    private final CalculoDni[] dni= {dni1,dni2,dni3,dni4,dni5,dni6,dni7,dni8,dni9,dni10};
    String[] letras= {"N","Z","F","C","N","H","F","S","H","D"};

    @Test
    void letrasCorrectas(){
        int i=0;
        for (CalculoDni d : dni) {
            assertEquals(d.getLetra(), letras[i]);
          i++;
        }
    }

}
