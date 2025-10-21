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
public class Voto {
    
    private String usuario;
    private Date fecha;
    private int cancion;

    public Voto(String usuario, Date fecha, int cancion) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.cancion = cancion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCancion() {
        return cancion;
    }

    public void setCancion(int cancion) {
        this.cancion = cancion;
    }
    
    
    
}
