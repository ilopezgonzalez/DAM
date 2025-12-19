/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NaturalId
    @Column(name = "codEstudio", unique = true)
    private String codEstudio;
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    private static final Long SERIALVERSIONUID = 9L;

//    @ManyToMany(mappedBy = "estudios")
//    private Set<Empleado> empleados;
    
    @OneToMany(mappedBy = "estudio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoEstudio> empleados;

    public Estudio() {
        empleados = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodEstudio() {
        return codEstudio;
    }

    public void setCodEstudio(String codEstudio) {
        this.codEstudio = codEstudio;
    }

    public List<EmpleadoEstudio> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoEstudio> empleados) {
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Estudio{" + "id=" + id + ", codEstudio=" + codEstudio + ", nombre=" + nombre + ", empleados=" + empleados + '}';
    }

    
    
    

    
}
