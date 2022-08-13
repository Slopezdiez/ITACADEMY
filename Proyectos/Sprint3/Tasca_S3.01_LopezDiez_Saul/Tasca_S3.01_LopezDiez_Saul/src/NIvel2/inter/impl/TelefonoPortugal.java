package NIvel2.inter.impl;

import NIvel2.inter.ITelefonos;

public class TelefonoPortugal implements ITelefonos{

	private String nombre;
	private int prefijo;
	private int numero;
	private String pais;



	public TelefonoPortugal() {
		this.nombre = "Joao Portugal";
		this.prefijo =13;
		this.numero = 75255845;
		this.pais = "Portugal";
	}

	@Override
	public void añadir() {
		// Aqui puede ir c�digo JDBC
		System.out.println("Se añadio telefono portugues");

	}



	@Override
	public String toString() {
		return "Telefono  [nombre=" + nombre + ", prefijo=" + prefijo + ", numero=" + numero + ", pais="
				+ pais + "]";
	}

}
