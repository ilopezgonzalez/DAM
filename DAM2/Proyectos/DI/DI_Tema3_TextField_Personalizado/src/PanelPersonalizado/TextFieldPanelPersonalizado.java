/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package PanelPersonalizado;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.StyleConstants;

/**
 *
 * @author damt209
 */
public class TextFieldPanelPersonalizado extends JTextField implements Serializable {

    private int numCaracteres;
    
    private ClaseDosColores colores;

    private Color colorPorDefectoFondo;
    private Color colorPorDefectoTexto;
    
    private Color color_inicial;
    private Color color_fondo;

    public TextFieldPanelPersonalizado() {
        super();
        colorPorDefectoFondo = getBackground();
        colorPorDefectoTexto = getForeground();

        super.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizarContenido();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizarContenido();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizarContenido();
            }
            
            private void analizarContenido(){
                if (getText().length()>=numCaracteres && colores!=null) {
                    setBackground(colores.getColorFondo());
                    setForeground(colores.getColorTexto());
                }else{
                    setBackground(colorPorDefectoFondo);
                    setForeground(colorPorDefectoTexto);
                }
            }
        });
        
        

    }

    

    public int getNumCaracteres() {
        return numCaracteres;
    }

    public void setNumCaracteres(int numCaracteres) {
        this.numCaracteres = numCaracteres;
    }

    public ClaseDosColores getColores() {
        return colores;
    }

    public void setColores(ClaseDosColores colores) {
        this.colores = colores;
    }

    public Color getColor_inicial() {
        return color_inicial;
    }

    public void setColor_inicial(Color color_inicial) {
        this.color_inicial = color_inicial;
    }

    public Color getColor_fondo() {
        return color_fondo;
    }

    public void setColor_fondo(Color color_fondo) {
        this.color_fondo = color_fondo;
    }
    
    

}
