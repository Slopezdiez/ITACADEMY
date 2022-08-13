package NIvel2;

import NIvel2.inter.IDirecciones;
import NIvel2.inter.ITelefonos;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<IDirecciones> direcciones;
    private ArrayList <ITelefonos> telefonos;


    public Agenda() {
        this.direcciones = new ArrayList<>();
        this.telefonos = new ArrayList<>();
    }


  public void añadirDirección(IDirecciones direccion){
        direcciones.add(direccion);
  }
    public void añadirTelefono(ITelefonos telefono){
        telefonos.add(telefono);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "direcciones=" + direcciones +
                ", telefonos=" + telefonos +
                '}';
    }
}
