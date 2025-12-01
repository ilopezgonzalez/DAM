/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Etiqueta;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author damt209
 */
public class DimensionesPropertyEditorSupport extends PropertyEditorSupport{
    
    private PanelDimensiones panelDimensiones=new PanelDimensiones();
    private Dimensiones dimensiones=new Dimensiones();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return panelDimensiones;
    }

    @Override
    public String getJavaInitializationString() {
        return "Etiqueta.PanelDatos("+dimensiones.getAnchura()+","+dimensiones.getAltura()+")";          
    }

    @Override
    public Object getValue() {
        Dimensiones dimensiones=panelDimensiones.getPropiedadSeleccionada();
        return dimensiones;
       
    }
    
    
    
}
