package Nivel3.commands;

import java.util.ArrayList;
import java.util.List;

public class Invocador {

	private List<IOperacion> operaciones = new ArrayList<>();

	public void recibirOperacion(IOperacion operacion) {
		this.operaciones.add(operacion);
	}

	public void realizarOperaciones() {
		this.operaciones.forEach(x -> x.execute());
		this.operaciones.clear();
	}

}
