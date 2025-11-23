package componentes;

import java.beans.*;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.event.*;

public class ComponenteAlbaran extends JLabel implements Serializable{

    private Producto producto;

    public ComponenteAlbaran() {
        setText("Sin producto");
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
        if (producto != null) {
            setText("Producto: " + producto.getNombre() + "\nTipo: " + producto.getTipo() + "\nUnidades: " + producto.getUnidades());
        }
    }
    
    
    
}
