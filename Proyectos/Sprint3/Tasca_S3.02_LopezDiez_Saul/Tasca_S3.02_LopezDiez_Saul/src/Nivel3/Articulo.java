package Nivel3;

public class Articulo {

    private String nom;
    private double importe;

    public Articulo(String nom, double importe) {
        this.nom = nom;
        this.importe = importe;
    }

    public String getNom() {
        return nom;
    }

    public double getImporte() {
        return importe;
    }
}
