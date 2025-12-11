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

    public Sueldo(double salario, double comision) {
        this.salario = salario;
        this.comision = comision;
    }
    
    
        
        

        

    
}
