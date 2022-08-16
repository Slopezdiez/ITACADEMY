package Nivel3.commands;

//Receiver/Request 
public class Vehicle {

	private String tipus;

	public Vehicle(String tipus) {
		this.tipus = tipus;
	}

	public void arrencar(Vehicle vehicle) {
		this.tipus = this.tipus ;
		System.out.println("[COMANDO ARRANCAR] El vehiculo " + vehicle.tipus + " arranca ");
	}

	public void accelerar(Vehicle vehicle) {
		this.tipus = this.tipus  ;
		System.out.println("[COMANDO ACELERAR] El vehiculo " + vehicle.tipus + " acelera ");
	}

	public void frenar (Vehicle vehicle) {
		this.tipus = this.tipus  ;
		System.out.println("[COMANDO DEPOSITAR] El vehiculo " + vehicle.tipus + " frena ");
	}



}
