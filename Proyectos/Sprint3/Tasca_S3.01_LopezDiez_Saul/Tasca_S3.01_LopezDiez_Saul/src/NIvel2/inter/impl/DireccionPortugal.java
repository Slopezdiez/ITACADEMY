package NIvel2.inter.impl;

import NIvel2.inter.IDirecciones;

public class DireccionPortugal implements IDirecciones {

	private String calle;
	private int numero;
	private String codigoPostal;
	private String pais;

	public DireccionPortugal() {
		this.calle = "calle de lisboa";
		this.numero = 01;
		this.codigoPostal = "70";
		this.pais = "Portugal";
	}

	@Override
	public void añadir() {
		// Aqui puede ir c�digo JDBC
		System.out.println("Se añadio dirección portuguesa");

	}



	@Override
	public String toString() {
		return "Direccion  [calle=" + calle + ", numero=" + numero + ", Codigo Postal=" + pais + ", pais="
				+ pais + "]";
	}
}
