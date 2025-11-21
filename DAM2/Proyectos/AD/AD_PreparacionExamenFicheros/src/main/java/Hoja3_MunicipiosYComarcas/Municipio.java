/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hoja3_MunicipiosYComarcas;

import java.io.Serializable;

/**
 *
 * @author ilopezgonzalez
 */
public class Municipio implements Serializable{
    
    private String nombre;
    private float extension;
    private int habitantes;
    private Comarca codigo;
    private int num_localidades;

    public Municipio(String nombre, float extension, int habitantes, Comarca codigo, int num_localidades) {
        this.nombre = nombre;
        this.extension = extension;
        this.habitantes = habitantes;
        this.codigo = codigo;
        this.num_localidades = num_localidades;
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

    public Comarca getCodigo() {
        return codigo;
    }

    public void setCodigo(Comarca codigo) {
        this.codigo = codigo;
    }

    public int getNum_localidades() {
        return num_localidades;
    }

    public void setNum_localidades(int num_localidades) {
        this.num_localidades = num_localidades;
    }

    
    
    
    
}
