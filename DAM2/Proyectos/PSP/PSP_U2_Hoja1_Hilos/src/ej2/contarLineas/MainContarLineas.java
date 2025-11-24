/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej2.contarLineas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class MainContarLineas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CuentaLineas hilo1=new CuentaLineas("build.xml");
            hilo1.start();
            hilo1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainContarLineas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El hilo ha terminado su trabajo. SALIENDO!!!");
    }
    
}
