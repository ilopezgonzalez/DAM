/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ilopezgonzalez
 */
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento {

    @Id
    private long departamento_id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "localidad", length = 25)
    private String localidad;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleados;

    public Departamento() {
    }

    public Departamento(long departamento_id, String nombre, String localidad) {
        empleados = new HashSet<>();
        this.departamento_id = departamento_id;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public long getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(long departamento_id) {
        this.departamento_id = departamento_id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.departamento_id ^ (this.departamento_id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        return this.departamento_id == other.departamento_id;
    }

    @Override
    public String toString() {
        return "Departamento{" + "departamento_id=" + departamento_id + ", nombre=" + nombre + ", localidad=" + localidad + '}';
    }
    
    

}
