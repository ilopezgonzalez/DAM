/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 * @author ilopezgonzalez
 */
@Entity
@DiscriminatorValue("OFICIAL")
public class Oficial extends Estudio {
    
    public Oficial(){
        super();
    }
    
}
