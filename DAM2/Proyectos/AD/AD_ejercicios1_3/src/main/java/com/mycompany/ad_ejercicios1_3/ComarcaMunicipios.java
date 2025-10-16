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
public class ComarcaMunicipios implements Serializable{
    
    private int codigoComarca;
    private String nombreComarca;
    private String[] nombresMunicipios;

    public ComarcaMunicipios(int codigoComarca, String nombreComarca, String[] nombresMunicipios) {
        this.codigoComarca = codigoComarca;
        this.nombreComarca = nombreComarca;
        this.nombresMunicipios = nombresMunicipios;
    }

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

    public String[] getNombresMunicipios() {
        return nombresMunicipios;
    }

    public void setNombresMunicipios(String[] nombresMunicipios) {
        this.nombresMunicipios = nombresMunicipios;
    }

    @Override
    public String toString() {
        String stringMunicipios="";
        for (String nombresMunicipio : nombresMunicipios) {
            stringMunicipios=stringMunicipios.concat(nombresMunicipio);
        }
        return "ComarcaMunicipios{" + "codigoComarca=" + codigoComarca + ", nombreComarca=" + nombreComarca + ", nombresMunicipios=" + stringMunicipios + '}';
    }
    
    
    
}
