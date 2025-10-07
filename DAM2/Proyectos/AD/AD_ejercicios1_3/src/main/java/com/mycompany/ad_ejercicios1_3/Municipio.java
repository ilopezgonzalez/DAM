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
public class Municipio implements Serializable{
    
    //Atributos
    
    private int codigo;
    private String nombre;
    private float extension;
    private int habitantes;
    private int num_localidades;
    private Comarca c;
    
    //Constructor

    public Municipio(int codigo, String nombre, float extension, int habitantes, int num_localidades, Comarca c) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.extension = extension;
        this.habitantes = habitantes;
        this.num_localidades = num_localidades;
        this.c = c;
    }

    
    
    //Getter&Setter

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public int getNum_localidades() {
        return num_localidades;
    }

    public void setNum_localidades(int num_localidades) {
        this.num_localidades = num_localidades;
    }

    public Comarca getC() {
        return c;
    }

    public void setC(Comarca c) {
        this.c = c;
    }
    
    //Metodos

    @Override
    public String toString() {
        return nombre+" ("+c.getNombreComarca()+")";
    }
    
    
    
    
    
    
}
