package n1ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

public class GestioButaques {
    private ArrayList<Butaca> butaques;

    public GestioButaques(ArrayList<Butaca> butaques) {
        this.butaques = new ArrayList<Butaca>();
    }

    public ArrayList<Butaca> getButaques() {
        return butaques;
    }

    public void afegirButaca(Butaca butaca) {
        try {
            int existe = cercarButaca(butaca.getNombreFila(), butaca.getNombreSeient());
            if (existe != -1) {
                throw new ExcepcioButacaOcupada();
            } else {
                butaques.add(butaca);
            }
        }catch (ExcepcioButacaOcupada e){
            System.out.println("Error Butaca ocupada: " +e.getMessage());
        }
    }


    public void eliminaButaca(int numeroFila, int numeroSeient)  {
        try {
            int existe = cercarButaca(numeroFila, numeroSeient);
            if (existe != -1) {
                butaques.remove(existe);
            } else {
                throw new ExcepcioButacaLliure();
            }
        }catch (ExcepcioButacaLliure e){
            System.out.println("Error Butaca lliure: " +e.getMessage());
        }
    }

    private int cercarButaca(int nombreFila, int nombreSeient) {
        int posicion=-1;
        boolean encontrado=false;
        Iterator <Butaca> it = butaques.iterator();
        if(butaques.isEmpty()){
            return -1;
        }else {
            try {
                while (it.hasNext() && !encontrado) {
                    Butaca butaca = it.next();
                    if (butaca.getNombreFila() == nombreFila && butaca.getNombreSeient() == nombreSeient) {
                        encontrado = true;
                    }
                    posicion++;
                }
                if (!encontrado) {
                    posicion = -1;
                }
            } catch (Exception e) {
                System.out.println("Error  " + e.getMessage());
                return -1;
            }
        }
        return posicion;
    }









}
