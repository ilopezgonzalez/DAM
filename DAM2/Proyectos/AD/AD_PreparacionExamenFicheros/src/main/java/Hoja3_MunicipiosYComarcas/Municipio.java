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
    
    private int codigo;
    private String nombre;
    private float extension;
    private int habitantes;
    private Comarca codigoComarca;
    private int num_localidades;

    public Municipio(int codigo, String nombre, float extension, int habitantes, Comarca codigoComarca, int num_localidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.extension = extension;
        this.habitantes = habitantes;
        this.codigoComarca = codigoComarca;
        this.num_localidades = num_localidades;
    }

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

    public Comarca getCodigoComarca() {
        return codigoComarca;
    }

    public void setCodigoComarca(Comarca codigoComarca) {
        this.codigoComarca = codigoComarca;
    }

    public int getNum_localidades() {
        return num_localidades;
    }

    public void setNum_localidades(int num_localidades) {
        this.num_localidades = num_localidades;
    }

   
    
}
