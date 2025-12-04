/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author alumno
 */
public class Partido {
    //Atributos de la clase
    private int id_partido;
    private String rival;
    private Date fecha_partido;
    private int aforo_total;
    private int entradas_disponibles;
    private float precio_entrada;

    public Partido(int id_partido, String rival, Date fecha_partido, int aforo_total, int entradas_disponibles, float precio_entrada) {
        this.id_partido = id_partido;
        this.rival = rival;
        this.fecha_partido = fecha_partido;
        this.aforo_total = aforo_total;
        this.entradas_disponibles = entradas_disponibles;
        this.precio_entrada = precio_entrada;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String riavl) {
        this.rival = rival;
    }

    public Date getFecha_partido() {
        return fecha_partido;
    }

    public void setFecha_partido(Date fecha_partido) {
        this.fecha_partido = fecha_partido;
    }

    public int getAforo_total() {
        return aforo_total;
    }

    public void setAforo_total(int aforo_total) {
        this.aforo_total = aforo_total;
    }

    public int getEntradas_disponibles() {
        return entradas_disponibles;
    }

    public void setEntradas_disponibles(int entradas_disponibles) {
        this.entradas_disponibles = entradas_disponibles;
    }

    public float getPrecio_entrada() {
        return precio_entrada;
    }

    public void setPrecio_entrada(float precio_entrada) {
        this.precio_entrada = precio_entrada;
    }
    
    
    
}
