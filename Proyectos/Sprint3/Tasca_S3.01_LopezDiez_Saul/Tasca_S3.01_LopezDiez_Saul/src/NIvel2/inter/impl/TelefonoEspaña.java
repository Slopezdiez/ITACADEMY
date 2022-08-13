package NIvel2.inter.impl;

import NIvel2.inter.ITelefonos;

public class TelefonoEspaña implements ITelefonos{

	private String nombre;
	private int prefijo;
	private int numero;
	private String pais;



	public TelefonoEspaña() {
		this.nombre = "Pepe Espaaña";
		this.prefijo =34;
		this.numero = 912587858;
		this.pais = "España";
	}

	@Override
	public void añadir() {
		// Aqui puede ir c�digo JDBC
		System.out.println("Se añadio telefono español");

	}



	@Override
	public String toString() {
		return "Telefono  [nombre=" + nombre + ", prefijo=" + prefijo + ", numero=" + numero + ", pais="
				+ pais + "]";
	}

}
