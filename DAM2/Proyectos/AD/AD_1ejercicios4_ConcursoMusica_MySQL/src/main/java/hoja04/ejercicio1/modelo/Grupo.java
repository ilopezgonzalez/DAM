/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.modelo;

import java.sql.Date;

/**
 *
 * @author damt209
 */
public class Grupo {
    
    private int codgrupo;
    private String nombre;
    private String localidad;
    private String estilo;
    private boolean esgrupo;
    private int annoGrab;
    private Date fechaEstreno;
    private String compania;

    public Grupo(int codgrupo, String nombre, String localidad, String estilo, boolean esgrupo, int annoGrab, Date fechaEstreno, String compania) {
        this.codgrupo = codgrupo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.estilo = estilo;
        this.esgrupo = esgrupo;
        this.annoGrab = annoGrab;
        this.fechaEstreno = fechaEstreno;
        this.compania = compania;
    }

    public int getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(int codgrupo) {
        this.codgrupo = codgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isEsgrupo() {
        return esgrupo;
    }

    public void setEsgrupo(boolean esgrupo) {
        this.esgrupo = esgrupo;
    }

    public int getAnnoGrab() {
        return annoGrab;
    }

    public void setAnnoGrab(int annoGrab) {
        this.annoGrab = annoGrab;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
    
    
    
}
