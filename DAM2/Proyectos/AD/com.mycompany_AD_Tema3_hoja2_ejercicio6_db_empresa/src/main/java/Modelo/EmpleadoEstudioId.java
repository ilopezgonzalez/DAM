/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ilopezgonzalez
 */
public class EmpleadoEstudioId implements Serializable{
    
    private static final long serialVersionUID=1L;
    private long empleado;
    private long estudio;

    public EmpleadoEstudioId() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, estudio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof EmpleadoEstudioId)) return false;
        EmpleadoEstudioId that=(EmpleadoEstudioId) obj;
        return Objects.equals(empleado, that.empleado)&& Objects.equals(estudio, that.estudio);  
    }
    
    
    
}
