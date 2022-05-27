package Nivel1.Ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalendario {

    private final Calendario calendario = new Calendario();

    @Test
    void posiciones(){
    assertTrue(calendario.mesos.size()==12);
    }

    @Test
    void noEsNula(){
        assertNotNull(calendario.mesos);
    }

    @Test
    void agostoBienPosicionado(){
        assertTrue(calendario.mesos.get(7)=="Agost");

    }


}
