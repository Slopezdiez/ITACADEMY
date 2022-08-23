package Nivel2.Fabrica.impl;

import Nivel2.Fabrica.IPagos;

public class PagoVacio implements IPagos {

	@Override
	public void pagar() {
		System.out.println("NO SE ESPECIFICO PAIS");
	}


}
