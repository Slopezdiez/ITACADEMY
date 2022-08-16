package Nivel3;

import Nivel3.commands.*;

public class Main {

	public static void main(String[] args) {
		Vehicle [] vehicles = {new Vehicle("Cotxe"), new Vehicle("Avió"), new Vehicle("Bicicleta"), new Vehicle("Vaixell") };

		for (Vehicle vehicle : vehicles){
			AcelerarImp acelerar= new AcelerarImp(vehicle);
			ArrencarImp arrencar=new ArrencarImp(vehicle);
			FrenarImp frenar=new FrenarImp(vehicle);
			Invocador invocador= new Invocador();
			invocador.recibirOperacion(arrencar);
			invocador.recibirOperacion(acelerar);
			invocador.recibirOperacion(frenar);
			invocador.realizarOperaciones();
		}
		



	}

}
