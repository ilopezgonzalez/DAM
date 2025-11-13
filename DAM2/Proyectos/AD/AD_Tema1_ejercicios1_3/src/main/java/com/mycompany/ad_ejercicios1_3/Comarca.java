/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_ejercicios1_3;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Comarca implements Serializable {
    
    //Atributos
    
    int codigoComarca;
    String nombreComarca;
    
    //Constructor

    public Comarca(int codigoComarca, String nombreComarca) {
        this.codigoComarca = codigoComarca;
        this.nombreComarca = nombreComarca;
    }
    
    //Getter&Setter

    public int getCodigoComarca() {
        return codigoComarca;
    }

    public void setCodigoComarca(int codigoComarca) {
        this.codigoComarca = codigoComarca;
    }

    public String getNombreComarca() {
        return nombreComarca;
    }

    public void setNombreComarca(String nombreComarca) {
        this.nombreComarca = nombreComarca;
    }
    
    //Metodos

    @Override
    public String toString() {
        return codigoComarca + (nombreComarca.isEmpty() ? "" : " - " + nombreComarca);
    }
    
    
    
    
}
