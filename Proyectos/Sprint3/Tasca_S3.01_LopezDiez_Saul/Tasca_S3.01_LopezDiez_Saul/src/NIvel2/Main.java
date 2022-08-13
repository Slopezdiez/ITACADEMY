package NIvel2;

import NIvel2.inter.FabricaAbstracta;
import NIvel2.inter.IDirecciones;
import NIvel2.inter.ITelefonos;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        FabricaAbstracta fabricaD = FabricaProductor.getFactory("Direccion");
        IDirecciones direcciones = fabricaD.getPaisDireccion("España");

        direcciones.añadir();
        agenda.añadirDirección(direcciones);
        direcciones = fabricaD.getPaisDireccion("Francia");
        direcciones.añadir();
        agenda.añadirDirección(direcciones);
        direcciones = fabricaD.getPaisDireccion("Portugal");
        direcciones.añadir();
        agenda.añadirDirección(direcciones);


        FabricaAbstracta fabricaT = FabricaProductor.getFactory("telefono");
        ITelefonos telefonos = fabricaT.getPaisTelefono("España");

        telefonos.añadir();
        agenda.añadirTelefono(telefonos);
        telefonos = fabricaT.getPaisTelefono("Francia");
        telefonos.añadir();
        agenda.añadirTelefono(telefonos);
        telefonos = fabricaT.getPaisTelefono("Portugal");
        telefonos.añadir();
        agenda.añadirTelefono(telefonos);
        System.out.println(agenda);
    }
}
