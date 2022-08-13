package NIvel2.inter.impl;

import NIvel2.inter.ITelefonos;

public class TelefonoFrancia implements ITelefonos{

	private String nombre;
	private int prefijo;
	private int numero;
	private String pais;



	public TelefonoFrancia() {
		this.nombre = "Olivier Francia";
		this.prefijo =72;
		this.numero = 58698845;
		this.pais = "Francia";
	}

	@Override
	public void añadir() {

		System.out.println("Se añadio telefono frances");

	}



	@Override
	public String toString() {
		return "Telefono  [nombre=" + nombre + ", prefijo=" + prefijo + ", numero=" + numero + ", pais="
				+ pais + "]";
	}

}
