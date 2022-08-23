package Nivel3;

public class Botiga {
    Cambio cambio;

    /* Constructor Injection */
    Botiga(Cambio injected) {
        cambio = injected;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    double cambio(double importe) {
        return  (cambio.cambio(importe));
    }
}
