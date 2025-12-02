/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.prueba;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SalaSuministros salaSuministros = new SalaSuministros();

        Doctora doctora1 = new Doctora(1, salaSuministros);

        Enfermero enfermero1 = new Enfermero(1, salaSuministros);
        Enfermero enfermero2 = new Enfermero(2, salaSuministros);

        doctora1.start();
        enfermero1.start();
        enfermero2.start();

        try {
            doctora1.join();
            enfermero1.join();
            enfermero2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (salaSuministros.getContadorCurados() == 6) {
            
            System.out.println("Enfermero " + enfermero1.getId_enfermero() + " ha atendido a: " + enfermero1.getNumCurados() + " pacientes");
            System.out.println("Enfermero " + enfermero2.getId_enfermero() + " ha atendido a: " + enfermero2.getNumCurados() + " pacientes");
        }

    }

}
