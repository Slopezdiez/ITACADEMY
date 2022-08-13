package NIvel2;

import NIvel2.inter.FabricaAbstracta;
import NIvel2.inter.IDirecciones;
import NIvel2.inter.ITelefonos;
import NIvel2.inter.impl.*;


public class TelefonosFabrica implements FabricaAbstracta {

	@Override
	public ITelefonos getPaisTelefono(String pais) {
		if (pais == null) {
			return new TelefonoVacio();
		}
		if (pais.equalsIgnoreCase("España")) {
			return new TelefonoEspaña();
		} else if (pais.equalsIgnoreCase("Francia")) {
			return new TelefonoFrancia();
		}else if (pais.equalsIgnoreCase("Portugal")) {
			return new TelefonoPortugal();
		}

		return new TelefonoVacio();
	}

	@Override
	public IDirecciones getPaisDireccion(String pais) {
		return null;
	}
}
