package Nivel1.observer;

public class Agencia2Observador extends Observador {

	public Agencia2Observador(AgentBorsa sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void actualizar() {
		System.out.println("Se comunica a Agencia 2  que el valor ha " + sujeto.getEstado());
	}
}
