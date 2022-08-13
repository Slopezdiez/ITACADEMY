package NIvel2;

import NIvel2.inter.FabricaAbstracta;

public class FabricaProductor {

	public static FabricaAbstracta getFactory(String tipoFabrica) {

		if (tipoFabrica.equalsIgnoreCase("Direccion")) {
			return new DireccionFabrica();

		} else if (tipoFabrica.equalsIgnoreCase("Telefono")) {
			return new TelefonosFabrica();
		}

		return null;
	}

}
