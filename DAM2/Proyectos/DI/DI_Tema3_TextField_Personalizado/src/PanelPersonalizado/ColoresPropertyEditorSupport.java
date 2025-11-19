/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PanelPersonalizado;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author damt209
 */
public class ColoresPropertyEditorSupport extends PropertyEditorSupport {

    private ColoresPanel coloresPanel=new ColoresPanel();
    
    
    @Override
    //Indica que es un panel personalizado
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    //Que panel vamos a utilizar, se debe crear un nuevo panel arriba
    public Component getCustomEditor() {
        return coloresPanel;
    }

    @Override
    //Se saca a traves del BeanInfo que tenemos que generar, en el BeanInfo hay que poner .class
    public String getJavaInitializationString() {
        Color colorFondo=coloresPanel.getPropiedadSeleccionada().getColorFondo();
        Color colorTexto=coloresPanel.getPropiedadSeleccionada().getColorTexto();
        return "new PanelPersonalizado.ClaseDosColores (new java.awt.Color("+colorFondo.getRGB()+"), new java.awt.Color("+colorTexto.getRGB()+"))";
    }

    @Override
    //Valores que devuelve el panel
    public Object getValue() {
        return coloresPanel.getPropiedadSeleccionada();
    }

}
