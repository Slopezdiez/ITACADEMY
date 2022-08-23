package Nivel2.Fabrica;

public class FabricaProductor {

	public static FabricaAbstracta getFactory(String tipoFabrica) {

		if (tipoFabrica.equalsIgnoreCase("Pago")) {
			return new TipoPagoFabrica();

		}

		return null;
	}

}
