package Nivel3;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) {

        ArrayList <Articulo> articulos = new ArrayList<Articulo>();
        Articulo articulo1 = new Articulo("Movil",350.57);
        Articulo articulo2 = new Articulo("Cargador",20.99);
        Articulo articulo3 = new Articulo("Funda",53.49);
        articulos.add(articulo1);
        articulos.add(articulo2);
        articulos.add(articulo3);

        ArrayList <Cambio> cambios = new ArrayList<>();
        Cambio cambio = new Cambio();
        Cambio cambioD=new CambioDolares();
        Cambio cambioL=new CambioLibras();
        Cambio cambioY=new CambioYenes();
        cambios.add(cambioD);
        cambios.add(cambioL);
        cambios.add(cambioY);
        Botiga botiga=new Botiga(cambio);

        for(Articulo a:articulos){
            System.out.println("El precio del articulo "+ a.getNom()+ "es :"+ a.getImporte()+ "€");
            for(Cambio c:cambios){
                botiga.setCambio(c);
                System.out.println("El precio del articulo " + a.getNom()+" en "+ c.getNombre()+"  es: "+ botiga.cambio(a.getImporte()));
            }
        }
    }
}
