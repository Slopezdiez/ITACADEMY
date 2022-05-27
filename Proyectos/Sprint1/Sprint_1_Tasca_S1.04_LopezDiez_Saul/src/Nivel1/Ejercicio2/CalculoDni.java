package Nivel1.Ejercicio2;

public class CalculoDni {
    private String letra;
    private int numero;

    public CalculoDni(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }

    public String getLetra() {
        return letra;
    }

    public int getNumero() {
        return numero;
    }

    private String calcularLetra(int numero) {
        String caracteres="TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero%23;
        return String.valueOf(caracteres.charAt(resto));
    }
}
