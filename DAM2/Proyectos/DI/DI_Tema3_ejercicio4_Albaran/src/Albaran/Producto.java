/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Albaran;

/**
 *
 * @author ilopezgonzalez
 */
public class Producto {
    
    private String nombre;
    private String tipo;
    private int unidades;

    public Producto(String nombre, String tipo, int unidades) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.unidades = unidades;
    }
    
    public Producto(){
        this.nombre="";
        this.tipo="";
        this.unidades=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", tipo=" + tipo + ", unidades=" + unidades + '}';
    }
    
    
    
}
