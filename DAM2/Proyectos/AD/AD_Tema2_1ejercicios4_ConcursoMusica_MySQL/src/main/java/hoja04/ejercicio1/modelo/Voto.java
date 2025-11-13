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
    
    private User usuario;
    private Date fecha;
    private Cancion cancion;

    public Voto(User usuario, Date fecha, Cancion cancion) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.cancion = cancion;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
    
    
    
}
