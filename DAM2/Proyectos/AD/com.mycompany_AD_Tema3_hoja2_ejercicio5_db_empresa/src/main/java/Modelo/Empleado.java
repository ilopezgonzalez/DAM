/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ilopezgonzalez
 */
@Entity
@Table(name = "EMPLEADOS")

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
    @Column(name = "oficio", length = 30)
    private String oficio;
    @Column(name = "fecha_alta", columnDefinition = "DATE")
    private LocalDate fechaAlta;
    //Se embebe la clase como un atributo, esta clase de de ser embebible
    @Embedded
    private Sueldo sueldo;

    @ManyToOne
    @JoinColumn(name = "departamento_id", foreignKey = @ForeignKey(name = "FK_EMPLEADO_DEPARTAMENTO"))
    private Departamento departamento;
    
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "empleados_tags",
//            joinColumns = @JoinColumn(name = "id_empleado"),
//            inverseJoinColumns = @JoinColumn(name = "codEstudio")
//    )
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoEstudio> estudios;
    
    
//    private Set<Estudio> estudios;

    
    public Empleado() {
        estudios=new LinkedList<>();
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public void setSueldo(Sueldo sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Empleado other = (Empleado) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", oficio=" + oficio + ", fechaAlta=" + fechaAlta + ", sueldo=" + sueldo + ", departamento=" + departamento + '}';
    }
    
    public void addEstudio(Estudio estudio, LocalDate fechaFinalizacion){
        EmpleadoEstudio empleadoEstudio=new EmpleadoEstudio();
        empleadoEstudio.setEmpleado(this);
        empleadoEstudio.setEstudio(estudio);
        empleadoEstudio.setFechaCreacion(fechaFinalizacion);
        estudios.add(empleadoEstudio);
        estudio.getEmpleados().add(empleadoEstudio);
    }
    
    public void removeEstudio(Estudio estudio){
        for (Iterator<EmpleadoEstudio> iterator = estudios.iterator(); iterator.hasNext();) {
            EmpleadoEstudio empleadoEstudio=iterator.next();
            if (empleadoEstudio.getEmpleado().equals(this)&& empleadoEstudio.getEstudio().equals(estudio)) {
                iterator.remove();
                empleadoEstudio.getEstudio().getEmpleados().remove(empleadoEstudio);
                empleadoEstudio.setEmpleado(null);
                empleadoEstudio.setEstudio(null);
            }
        }
    }

    
}
