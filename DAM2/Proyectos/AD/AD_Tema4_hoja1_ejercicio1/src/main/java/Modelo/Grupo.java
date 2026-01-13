/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

/**
 *
 * @author damt209
 */

@Entity
@Table(name = "GRUPOS")
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGrupo;
    @Column (name = "nombre")
    private String nombre;
    @Column(name = "localidad")
    private String localidad;
    @Column (name = "estilo")
    private String estilo;
    @Column (name = "yearFundacion")
    private Integer yearFundacion;
    @Embedded
    private Contacto contacto;
    
    @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cancion> canciones;

    public Grupo() {
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Integer getYearFundacion() {
        return yearFundacion;
    }

    public void setYearFundacion(Integer yearFundacion) {
        this.yearFundacion = yearFundacion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", nombre=" + nombre + ", localidad=" + localidad + ", estilo=" + estilo + ", yearFundacion=" + yearFundacion + '}';
    }
    
    
    
}
