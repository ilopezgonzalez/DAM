/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.modelo;

/**
 *
 * @author ASUS
 */
public class PeliculaPersonajeActuacion {
    
    private String tituloPelicula;
    private int yearPelicula;
    private String nombrePersonaje;
    private String nombreActor;

    public PeliculaPersonajeActuacion(String tituloPelicula, int yearPelicula, String nombrePersonaje, String nombreActor) {
        this.tituloPelicula = tituloPelicula;
        this.yearPelicula = yearPelicula;
        this.nombrePersonaje = nombrePersonaje;
        this.nombreActor = nombreActor;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public int getYearPelicula() {
        return yearPelicula;
    }

    public void setYearPelicula(int yearPelicula) {
        this.yearPelicula = yearPelicula;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    @Override
    public String toString() {
        return "PeliculaPersonajeActuacion{" + "tituloPelicula=" + tituloPelicula + ", yearPelicula=" + yearPelicula + ", nombrePersonaje=" + nombrePersonaje + ", nombreActor=" + nombreActor + '}';
    }
    
    
    
    
}
