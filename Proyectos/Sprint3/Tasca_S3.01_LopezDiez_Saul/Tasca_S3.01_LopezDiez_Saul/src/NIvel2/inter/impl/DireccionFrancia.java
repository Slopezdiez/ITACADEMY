package NIvel2.inter.impl;

import NIvel2.inter.IDirecciones;

public class DireccionFrancia implements IDirecciones {

	private String calle;
	private int numero;
	private String codigoPostal;
	private String pais;

	public DireccionFrancia() {
		this.calle = "calle de paris";
		this.numero = 66;
		this.codigoPostal = "102458";
		this.pais = "Francia";
	}

	@Override
	public void añadir() {
		// Aqui puede ir c�digo JDBC
		System.out.println("Se añadio dirección francesa");

	}



	@Override
	public String toString() {
		return "Direccion  [calle=" + calle + ", numero=" + numero + ", Codigo Postal=" + pais + ", pais="
				+ pais + "]";
	}
}
