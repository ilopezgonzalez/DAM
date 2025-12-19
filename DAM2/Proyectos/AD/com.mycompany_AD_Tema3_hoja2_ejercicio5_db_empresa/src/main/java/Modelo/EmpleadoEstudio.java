/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ilopezgonzalez
 */
@Entity
@Table(name = "empleados_estudios")
@IdClass(EmpleadoEstudioId.class)

public class EmpleadoEstudio {

    @Id
    @ManyToOne
    @JoinColumn(name = "empleado_id", foreignKey = @ForeignKey(name = "FK_EMPLEADO_ESTUDIO_EMPLEADO"))
    private Empleado empleado;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "estudio_id", foreignKey = @ForeignKey(name = "FK_EMPLEADO_ESTUDIO_ESTUDIO"))
    private Estudio estudio;
    
    @Column(name = "fecha_fin_estudio")
    private LocalDate fechaCreacion;

    public EmpleadoEstudio() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, estudio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this== obj) return true; 
        if (!(obj instanceof EmpleadoEstudio)) return false;
        EmpleadoEstudio that= (EmpleadoEstudio) obj;
        return Objects.equals(empleado, that.empleado) && Objects.equals(estudio, that.estudio);
        
        
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "EmpleadoEstudio{" + "empleado=" + empleado + ", estudio=" + estudio + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    

    
    
    
    
    
    
    
}
