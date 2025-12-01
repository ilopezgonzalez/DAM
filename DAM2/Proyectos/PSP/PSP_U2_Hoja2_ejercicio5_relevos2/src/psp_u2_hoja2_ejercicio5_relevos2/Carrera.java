/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio5_relevos2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Carrera {
    
    private HiloCorredor corredor;

    public Carrera() {
    }

    
    
    
    public synchronized void iniciarCarrera(int idCorredor) {
        try {
            System.out.println("El corredor " + idCorredor + " llega a la salida");
            wait();
            System.out.println("El corredor " + idCorredor + " sale");
            Thread.sleep(2000);
            System.out.println("El corredor " + idCorredor + " llega");
            System.out.println("El corredor " + idCorredor + " pasa el relevo");
            notify();

        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
