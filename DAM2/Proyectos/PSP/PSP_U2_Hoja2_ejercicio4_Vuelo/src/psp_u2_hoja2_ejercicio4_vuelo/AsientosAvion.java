/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio4_vuelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class AsientosAvion {
    
    private int asientosLibres;
    
    private HiloClienteCompra hiloClienteCompra;

    public AsientosAvion(int asientosLibres) {
        this.asientosLibres = 5;
    }
    
    public synchronized void reservaAsientos(int idCliente, int asientosPeticion){
        if (asientosLibres>asientosPeticion) {
            try {
                Thread.sleep(1000);
                asientosLibres=asientosLibres-asientosPeticion;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Logger.getLogger(AsientosAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
