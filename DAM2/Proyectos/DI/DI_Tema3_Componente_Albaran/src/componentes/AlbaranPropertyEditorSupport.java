/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author ilopezgonzalez
 */
public class AlbaranPropertyEditorSupport extends PropertyEditorSupport {

    private PanelAlbaran albaran = new PanelAlbaran();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return albaran;
    }

    @Override
    public String getJavaInitializationString() {
        String nombre = albaran.seleccionar().getNombre();
        String tipo = albaran.seleccionar().getTipo();
        int unidades = albaran.seleccionar().getUnidades();

        return "new componentes.Producto(\"" + nombre + "\", \"" + tipo + "\", " + unidades + ")";
    }

    @Override
    public Object getValue() {
        return albaran.seleccionar();
    }

}
