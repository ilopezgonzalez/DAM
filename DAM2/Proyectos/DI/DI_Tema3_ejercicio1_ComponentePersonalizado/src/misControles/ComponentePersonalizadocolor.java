/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package misControles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author damt209
 */
public class ComponentePersonalizadocolor extends JTextField implements Serializable {

    private int numCaracteres;
    
    private Color colorFondo;
    private Color colorPorDefecto;
    
    private Color color_fondo;
    private Color color_inicial;

    
    public ComponentePersonalizadocolor(){
        super();
        colorPorDefecto=getBackground();
        super.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizaContenido();
            }
            
            private void analizaContenido(){
                if (getText().length()>=numCaracteres) {
                    setBackground(colorFondo);
                }else{
                    setBackground(colorPorDefecto);
                }
            } 
        });
    }
    
       @Override
    protected void paintComponent(Graphics g) {
        if (getText().length()>=numCaracteres) {
            setBackground(color_fondo);
        }else{
            setBackground(color_inicial);
        }
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public int getNumCaracteres() {
        return numCaracteres;
    }

    public void setNumCaracteres(int numCaracteres) {
        this.numCaracteres = numCaracteres;
    }

    public Color getColor_fondo() {
        return color_fondo;
    }

    public void setColor_fondo(Color color_fondo) {
        this.color_fondo = color_fondo;
    }

    public Color getColor_incial() {
        return color_inicial;
    }

    public void setColor_incial(Color color_inicial) {
        this.color_inicial = color_inicial;
    }

    
}
