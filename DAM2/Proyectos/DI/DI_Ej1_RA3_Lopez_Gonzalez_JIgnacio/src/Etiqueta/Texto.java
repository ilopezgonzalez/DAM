/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package Etiqueta;

import java.awt.Graphics;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author damt209
 */
public class Texto extends JLabel implements Serializable {
    
    private Dimensiones dimensiones=new Dimensiones();
    private int anchura;
    private int altura;

    public Texto(int anchura, int altura) {
        this.anchura = anchura;
        this.altura = altura;
    }

    public Texto() {
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    
   

    
    
    
    
    
//    public void setText(String text) {
//        Dimensiones dimensiones=panelDimensiones.getPropiedadSeleccionada();
//        this.setText("Anchura: "+dimensiones.getAnchura()+" | Altura: "+dimensiones.getAltura());
//    }

    
    
    
    @Override
    public void setText(String text) {
        setText("Anchura: "+dimensiones.getAnchura()+", Altura: "+dimensiones.getAltura());
    }

   

    
    

    
    
    
    
    
}
