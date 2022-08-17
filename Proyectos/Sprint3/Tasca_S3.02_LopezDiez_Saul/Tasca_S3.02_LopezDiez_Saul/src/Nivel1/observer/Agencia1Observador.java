package Nivel1.observer;

public class Agencia1Observador extends Observador {
	public Agencia1Observador(AgentBorsa sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void actualizar() {
		System.out.println("Se comunica a Agencia 1  que el valor ha " + sujeto.getEstado());
	}
}
