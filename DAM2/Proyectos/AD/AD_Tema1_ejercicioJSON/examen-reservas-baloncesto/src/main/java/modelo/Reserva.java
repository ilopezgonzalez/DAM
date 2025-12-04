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
public class Reserva {
    
    private int id_reserva;
    private Socio socio;
    private Partido partido;
    private int num_entradas;
    private Date fecha_reserva;
    private boolean confirmada;

    public Reserva(int id_reserva, Socio socio, Partido partido, int num_entradas, Date fecha_reserva, boolean confirmada) {
        this.id_reserva = id_reserva;
        this.socio = socio;
        this.partido = partido;
        this.num_entradas = num_entradas;
        this.fecha_reserva = fecha_reserva;
        this.confirmada = confirmada;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getNum_entradas() {
        return num_entradas;
    }

    public void setNum_entradas(int num_entradas) {
        this.num_entradas = num_entradas;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }
    
    
    
    
}
