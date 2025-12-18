/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author ilopezgonzalez
 */

//Se crea la clase como embebible
@Embeddable
public class Sueldo {
       
        @Column(nullable = false, columnDefinition = "decimal (8,2)")
        private double salario;
        @Column(columnDefinition = "decimal (6,2)")
        private double comision;

    public Sueldo() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    

    @Override
    public String toString() {
        return "Sueldo{" + "salario=" + salario + ", comision=" + comision + '}';
    }
    
    

}
