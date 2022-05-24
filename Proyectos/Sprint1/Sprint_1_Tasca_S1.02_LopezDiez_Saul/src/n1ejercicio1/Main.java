package n1ejercicio1;

//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.system;

public class Main {

public static void main(String[] args) throws VendaBuidaException {

        Venta venta = new Venta();
        Producto producto = new Producto("Arroz",100);
        System.out.println("Creado un producto:  "+producto);
        try {
        System.out.println("// Se intenta calcular venta sin añadir productos");
            venta.calcularTotal(0);

        }catch(VendaBuidaException e){
            System.out.println("Se lanzo la excepcion de venta vacia");
        }
       try {
            System.out.println("// Se añade un producto");
            venta.anadirProductos(producto);
            System.out.println(venta.getProductos().toString());
            System.out.println("// Se calcula la venta con error fuera de limite");
            venta.calcularTotal(1);

       }catch(IndexOutOfBoundsException e){
            System.out.println("Se lanzó excepcion fuera de limites");
           System.out.println(e);
        }
        System.out.println("// Se calcula la venta sin error fuera de limite");
        venta.calcularTotal(0);
    }
}
