package Nivel2;


import Nivel2.Fabrica.IPagos;

import java.util.ArrayList;

public class Pago {

    private ArrayList<IPagos> pagos;



    public Pago() {
        this.pagos = new ArrayList<>();

    }


  public void añadirPagos(IPagos pago){
        pagos.add(pago);
  }


    @Override
    public String toString() {
        return "Pagos{" +
                "tipos=" + pagos +

                '}';
    }
}
