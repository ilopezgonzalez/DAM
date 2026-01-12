package com.example.ejerciciopermisosleercontactos;

import java.util.Date;

public class Contacto {

    private String nombre;
    private String telefono;
    private Long fechaModificacion;


    public Contacto(String nombre, String telefono, Long fechaModificacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaModificacion = fechaModificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Long fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", Telefono='" + telefono;
    }
}



