package Nivel1.Ejercicio2;

public class Treballador {
    private String nom, cognom;
    private int preuHora;

    public Treballador(String nom, String cognom, int preuHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuHora = preuHora;
    }

    public int calcualrSou(int nombreHores){return nombreHores*preuHora;}

    //@Deprecated
    public Boolean aguinaldo(){
        return false;
    }

}
