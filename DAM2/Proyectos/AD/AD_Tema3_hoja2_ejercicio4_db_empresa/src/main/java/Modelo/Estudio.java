/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Empleado;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author ilopezgonzalez
 */
@Entity
@Table(name = "ESTUDIOS")
public class Estudio {

    @Id
    private long estudio_id;
    @NaturalId
    @Column(name = "codEstudio", length = 5, unique = true)
    private String codEstudio;
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "estudios")
    private Set<Empleado> empleado;

    public Estudio() {
        empleado = new HashSet<>();
    }

    public long getEstudio_id() {
        return estudio_id;
    }

    public void setEstudio_id(long estudio_id) {
        this.estudio_id = estudio_id;
    }

    public String getCodEstudio() {
        return codEstudio;
    }

    public void setCodEstudio(String codEstudio) {
        this.codEstudio = codEstudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Set<Empleado> empleados) {
        this.empleado = empleados;
    }

    @Override
    public String toString() {
        return "Estudio{" + "estudio_id=" + estudio_id + ", codEstudio=" + codEstudio + ", nombre=" + nombre + ", empleados=" + empleado + '}';
    }

}
