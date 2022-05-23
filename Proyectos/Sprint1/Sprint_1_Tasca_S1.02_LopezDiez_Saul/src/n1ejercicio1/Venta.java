package n1ejercicio1;

import java.util.ArrayList;
import java.util.Collection;

public class Venta {

    private ArrayList <Producto> productos;
    private int precioTotal;

    public Venta() {

    }

    public Venta(ArrayList<Producto> productos) {

        this.productos = productos;
    }

    public Collection<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void anadirProductos(Producto producto) {
        if (productos==null){
            this.productos = new ArrayList<Producto>();
        }
        productos.add(producto);
    }

    public void quitarrProductos(Producto producto) {
        productos.remove(producto);
    }


    public void calcularTotal( int prueba) throws ExcepcionPersonalizada {

        if (productos == null) {
            throw new ExcepcionPersonalizada("Para hacer la venta, debes añadir productos");
        }

        int size=productos.size();
        for (int i = 0; i < size; i++) {
            if(prueba==1){
                i=3;
            }
            if(i>productos.size()){
                throw new ExcepcionPersonalizada("Fuera de limites");
            }
            this.precioTotal = this.precioTotal+ productos.get(i).getPrecio();
        }
        System.out.println("El precio total es: "+precioTotal);
    }
}
