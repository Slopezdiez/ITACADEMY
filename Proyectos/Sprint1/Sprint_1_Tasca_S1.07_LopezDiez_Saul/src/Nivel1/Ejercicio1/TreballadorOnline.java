package Nivel1.Ejercicio1;

public class TreballadorOnline extends Treballador{
    public final int internet;

    public TreballadorOnline(String nom, String cognom, int preuHora, int internet) {
        super(nom, cognom, preuHora);
        this.internet = internet;
    }

    @Override
    public int calcualrSou(int nombreHores) {
        return super.calcualrSou(nombreHores)+this.internet;
    }
}
