/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_tema3_hoja1_hibernate_tradicional.modelo;


/**
 *
 * @author damt209
 */


public class Direccion {

    
    private Long id;
    private String calle;
    private String ciudad;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode()
                : System.identityHashCode(this);
    }

}
