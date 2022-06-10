package Nivel1.Ejercicio2;

public class TreballadorPresencial extends Treballador {

    private static int benzina;

    public TreballadorPresencial(String nom, String cognom, int preuHora, int benzina) {
        super(nom, cognom, preuHora);
        this.benzina=benzina;
    }

    @Override
    public int calcualrSou(int nombreHores) {
        return super.calcualrSou(nombreHores)+this.benzina;
    }

    @Override
    @Deprecated
    public Boolean aguinaldo(){
        return true;
    }


}
