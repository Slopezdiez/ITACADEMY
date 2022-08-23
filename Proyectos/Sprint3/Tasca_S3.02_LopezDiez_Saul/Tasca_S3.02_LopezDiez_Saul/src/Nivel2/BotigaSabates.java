package Nivel2;

import Nivel2.Fabrica.FabricaAbstracta;
import Nivel2.Fabrica.IPagos;

public class BotigaSabates {

    //private Pago pago;
    private FabricaAbstracta fabricaD;
    private IPagos pagos;
    private PasarelaPago pasarelaPago;

    private String nom;

    public BotigaSabates(String nom) {
        this.nom = nom;
        System.out.println("Creada la nova tenda de Sabates "+ nom);
    }

/*    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }*/

    public FabricaAbstracta getFabricaD() {
        return fabricaD;
    }

    public void setFabricaD(FabricaAbstracta fabricaD) {
        this.fabricaD = fabricaD;
    }

    public IPagos getPagos() {
        return pagos;
    }

    public void setPagos(IPagos pagos) {
        this.pagos = pagos;
    }

    public PasarelaPago getPasarelaPago() {
        return pasarelaPago;
    }

    public void setPasarelaPago(PasarelaPago pasarelaPago) {
        this.pasarelaPago = pasarelaPago;
    }
}
