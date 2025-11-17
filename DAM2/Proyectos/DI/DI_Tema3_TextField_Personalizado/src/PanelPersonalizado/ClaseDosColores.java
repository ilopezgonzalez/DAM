/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PanelPersonalizado;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author damt209
 */
public class ClaseDosColores implements Serializable{
    
    private Color colorFondo;
    private Color colorTexto;

    public ClaseDosColores(Color colorFondo, Color colorTexto) {
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public Color getColorTexto() {
        return colorTexto;
    }
    
    
    
    
    
}
