package Nivel2.Fabrica;

import Nivel2.Fabrica.impl.PagoPaypal;
import Nivel2.Fabrica.impl.PagoTarjeta;
import Nivel2.Fabrica.impl.PagoVacio;
//import Nivel2.Ejerciciov2.Fabrica.impl.impl.*;

public class TipoPagoFabrica implements FabricaAbstracta{

/*	@Override
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
	}*/

	@Override
	public IPagos getTipoPago(String tipo) {
		if (tipo == null) {
			return new PagoVacio();
		}
		if (tipo.equalsIgnoreCase("Tarjeta")) {
			return new PagoTarjeta();
		} else if (tipo.equalsIgnoreCase("Paypal")) {
			return new PagoPaypal();
		}

		return new PagoVacio();
	}
}
