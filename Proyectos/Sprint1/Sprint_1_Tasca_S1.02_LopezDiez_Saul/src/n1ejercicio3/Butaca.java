package n1ejercicio3;

import java.util.Objects;

public class Butaca {
    private int nombreFila, nombreSeient;
    private String persona;

    public Butaca(int nombreFila, int nombreSeient, String persona) {
        this.nombreFila = nombreFila;
        this.nombreSeient = nombreSeient;
        this.persona = persona;
    }

    public int getNombreFila() {
        return nombreFila;
    }

    public int getNombreSeient() {
        return nombreSeient;
    }

    public String getPersona(){
        return persona;
    }

    @Override
    public boolean equals(Object o) {
        Butaca butaca = (Butaca) o;
        if(this.nombreFila== butaca.getNombreFila() && this.nombreSeient== butaca.getNombreSeient()) return true;
        else return false;
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Butaca butaca = (Butaca) o;
        return nombreFila == butaca.nombreFila && nombreSeient == butaca.nombreSeient;*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFila, nombreSeient);
    }

    @Override
    public String toString() {
        return "Fila= " + nombreFila +
                ", Seient=" + nombreSeient +
                ", Persona=" + persona ;
    }
}
