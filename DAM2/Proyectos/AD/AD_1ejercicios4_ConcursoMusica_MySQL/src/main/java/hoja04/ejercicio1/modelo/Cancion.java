/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.modelo;

import java.sql.Time;

/**
 *
 * @author damt209
 */
public class Cancion {
    
    private int num_Cancion;
    private int grupo;
    private Time duracion;
    private String titulo;
    private int total_votos;

    public Cancion(int num_Cancion, int grupo, Time duracion, String titulo, int total_votos) {
        this.num_Cancion = num_Cancion;
        this.grupo = grupo;
        this.duracion = duracion;
        this.titulo = titulo;
        this.total_votos = total_votos;
    }

    public int getNum_Cancion() {
        return num_Cancion;
    }

    public void setNum_Cancion(int num_Cancion) {
        this.num_Cancion = num_Cancion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotal_votos() {
        return total_votos;
    }

    public void setTotal_votos(int total_votos) {
        this.total_votos = total_votos;
    }
    
    
    
}
