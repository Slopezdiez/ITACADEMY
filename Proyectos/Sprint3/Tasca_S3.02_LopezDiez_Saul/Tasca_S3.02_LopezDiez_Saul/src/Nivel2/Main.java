package Nivel2;

import Nivel2.Fabrica.FabricaProductor;


public class Main {

    public static void main(String[] args) {
        BotigaSabates botigaSabates = new BotigaSabates("Zapatitos");
        botigaSabates.setFabricaD(FabricaProductor.getFactory("Pago"));
        botigaSabates.setPagos(botigaSabates.getFabricaD().getTipoPago("Tarjeta"));
        botigaSabates.setPasarelaPago((PasarelaPago) botigaSabates.getPagos());
        botigaSabates.getPasarelaPago().executeWith(() ->System.out.println("Todos los pagos hechos!"));
        botigaSabates.setPagos(botigaSabates.getFabricaD().getTipoPago("Paypal"));
        botigaSabates.setPasarelaPago((PasarelaPago) botigaSabates.getPagos());
        botigaSabates.getPasarelaPago().executeWith(() ->System.out.println("Todos los pagos hechos!"));

    }
}
