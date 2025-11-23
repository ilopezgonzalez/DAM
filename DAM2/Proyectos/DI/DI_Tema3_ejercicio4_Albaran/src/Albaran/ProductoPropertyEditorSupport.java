/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Albaran;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author ilopezgonzalez
 */
public class ProductoPropertyEditorSupport extends PropertyEditorSupport {

    private PanelProducto panelProducto=new PanelProducto();


    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return panelProducto;
    }

    @Override
    public String getJavaInitializationString() {
        Producto producto = panelProducto.getPropiedadSeleccionada();
        if (producto==null) {
            return "new Albaran.Producto()";
        }
        return "new Albaran.Producto(\"" + producto.getNombre() + "\", \"" + producto.getTipo() + "\", " + producto.getUnidades() + ")";

    }

    @Override
    public Object getValue() {
        return panelProducto.getPropiedadSeleccionada();
    }

}
