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
    
    private Color color_fondo;
    private Color color_inicial;
    

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

    public Color getColor_fondo() {
        return color_fondo;
    }

    public void setColor_fondo(Color color_fondo) {
        this.color_fondo = color_fondo;
    }

    public Color getColor_inicial() {
        return color_inicial;
    }

    public void setColor_inicial(Color color_inicial) {
        this.color_inicial = color_inicial;
    }
    
    
    
    
    
}
