/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.modelo;

/**
 *
 * @author damt209
 */
public class Componente {
    
    private int idComp;
    private String nombre;
    private String apellido;
    private String alias;
    private String funcion;
    private int grupo;

    public Componente(int idComp, String nombre, String apellido, String alias, String funcion, int grupo) {
        this.idComp = idComp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.funcion = funcion;
        this.grupo = grupo;
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
    
}
