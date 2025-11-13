package bd.ejemplo02;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cic
 */
public class Ejemplo02 {

    public static void main(String[] args) {

        // para realizar el buble
        boolean hasta = true;
        // primero creamos nuestra coleccion de productos a insertar posteriormente a la base de datos
        Set<Producto> productos = new HashSet<>();

        do {
            String nombre = Teclado.introTexto("introduce el nombre del producto");
            int cantidad = Teclado.introEnteroPositivo("introduce la cantidad");
            Producto producto = new Producto(nombre, cantidad);
            if (productos.add(producto)) {
                System.out.println("producto insertado en la coleccion correctamente");
            } else {
                if (productos.contains(producto)) {
                    System.out.println("El producto ya existe");
                }
            }
            hasta = Teclado.introBoolean("Deseas introducir otro producto (S/N)");
        } while (hasta);
         //establecer la conexión
            AccesoBaseDatos conexion = AccesoBaseDatos.getInstance();
        // recorremos la coleccion de productos y vamos insertando en la base de datos
        for (Producto produ : productos) {
            // insertar
           FuncionesBD.insertarProductosBD(produ.getNombre(), produ.getCantidad());
        }
        // ahora mostramos de BD los registros que tengan más de 5 unidades pero de la bd
        System.out.println("realizar la consulta con cantidad >5");
        FuncionesBD.getProductosCantidad(5);      
        System.out.println("realizar de nuevo la consulta pero utilizando la segunda cantidad 10");
        FuncionesBD.getProductosCantidad2(10);
        // cerrar conexion
        if (conexion.cerrar()){
             System.out.println("BD cerrada");
        } else {
            System.out.println("BD no cerrada");
        }
    }
}
