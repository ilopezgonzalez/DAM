/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author ilopezgonzalez
 */
public class Rectangulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
    
    public double calcularArea(){
        double area=this.ancho*this.alto;
        return area;
    }
    
    public double calcularPerimetro(){
        double perimetro=(2*this.ancho)+(2*this.alto);
        return perimetro;
    }
    
}
