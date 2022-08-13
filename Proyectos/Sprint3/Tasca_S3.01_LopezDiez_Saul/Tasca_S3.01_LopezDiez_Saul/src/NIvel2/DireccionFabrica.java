package NIvel2;

import   NIvel2.inter.FabricaAbstracta;
import NIvel2.inter.IDirecciones;
import NIvel2.inter.ITelefonos;
import NIvel2.inter.impl.*;

public class DireccionFabrica implements FabricaAbstracta{

	@Override
	public IDirecciones getPaisDireccion(String pais) {
		if (pais == null) {
			return new DireccionVacia();
		}
		if (pais.equalsIgnoreCase("España")) {
			return new DireccionEspaña();
		} else if (pais.equalsIgnoreCase("Francia")) {
			return new DireccionFrancia();
		} else if (pais.equalsIgnoreCase("Portugal")) {
			return new DireccionPortugal();
		}

		return new DireccionVacia();
	}

	@Override
	public ITelefonos getPaisTelefono(String pais) {
		return null;
	}
}
