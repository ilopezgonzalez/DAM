package Albaran;

import java.io.Serializable;
import javax.swing.JLabel;

public class ComponenteAlbaran extends JLabel implements Serializable {

    private Producto producto;

    public ComponenteAlbaran() {
        setText("PruebaAlbaran"); 
    }

    public Producto getProducto() {
        return producto;
    }

    
    
    

//    public void setProducto(Producto producto) {
//       
//
//        if (producto != null) {
//            setText("Nombre: " + producto.getNombre()
//                    + "  Tipo: " + producto.getTipo()
//                    + "  Unidades: " + producto.getUnidades());
//        } else {
//            setText("Algun campo estaba vacio"); 
//        }
//    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
