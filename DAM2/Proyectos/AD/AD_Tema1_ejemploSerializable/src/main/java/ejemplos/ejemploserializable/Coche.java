/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.ejemploserializable;

import java.io.Serializable;

/**
 *
 * @author cic
 */
public class Coche implements Serializable {

    private String marca;
    private double velocidad;
    private int gasolina;

    public Coche(String marca, double velocidad, int gasolina) {
        this.marca = marca;
        this.velocidad = velocidad;
        this.gasolina = gasolina;

    }

    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", velocidad = " 
                + velocidad + ", gasolina =" + gasolina + '}';
    }
}
