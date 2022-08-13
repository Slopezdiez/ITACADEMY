package NIvel2.inter.impl;

import NIvel2.inter.IDirecciones;

public class DireccionEspaña implements IDirecciones {

	private String calle;
	private int numero;
	private String codigoPostal;
	private String pais;

	public DireccionEspaña() {
		this.calle = "calle de madrid";
		this.numero = 13;
		this.codigoPostal = "28016";
		this.pais = "España";
	}

	@Override
	public void añadir() {
		// Aqui puede ir c�digo JDBC
		System.out.println("Se añadio dirección española");

	}



	@Override
	public String toString() {
		return "Direccion  [calle=" + calle + ", numero=" + numero + ", Codigo Postal=" + pais + ", pais="
				+ pais + "]";
	}
}
