package Nivel2.Fabrica.impl;

import Nivel2.Fabrica.IPagos;
import Nivel2.PasarelaPago;

public class PagoTarjeta extends PasarelaPago implements IPagos {


	private int numero;
	private String tipo;
	public String getTipo() {
		return tipo;
	}
	public PagoTarjeta() {
		this.numero = 685877885;
		this.tipo = "Tarjeta";
	}

	@Override
	public void pagar() {
		// Aqui puede ir c�digo JDBC
		System.out.println("Se pago con "+this.tipo+" numero: "+ this.numero);

	}


	@Override
	public String toString() {
		return "PagoTarjeta{" +
				"numero=" + numero +
				", tipo='" + tipo + '\'' +
				'}';
	}

	@Override
	public void execute() {
		System.out.println("Pago tarjeta");
	}
}
