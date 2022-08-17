package Nivel1.observer;

public class Agencia3Observador extends Observador {

	public Agencia3Observador(AgentBorsa sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void actualizar() {
		System.out.println("Se comunica a Agencia 3  que el valor ha " + sujeto.getEstado());
	}
}
