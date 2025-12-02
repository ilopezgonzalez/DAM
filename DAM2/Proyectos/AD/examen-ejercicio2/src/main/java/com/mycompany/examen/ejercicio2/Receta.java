/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen.ejercicio2;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Receta implements Serializable{
    
    private String id;
    private String nombre;
    private int calorias;
    private static final long serialVersionUID=2L;

    public Receta(String id, String nombre, int calorias) {
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", nombre=" + nombre + ", calorias=" + calorias + '}';
    }
    
    
    
}
