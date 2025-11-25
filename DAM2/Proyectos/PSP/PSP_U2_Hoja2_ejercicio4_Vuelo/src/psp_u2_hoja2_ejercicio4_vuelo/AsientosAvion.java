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

    public AsientosAvion() {
        this.asientosLibres = 5;
    }
    
    public synchronized void reservaAsientos(int idCliente, int asientosPeticion){
        System.out.println("El cliente numero "+idCliente+" intenta comprar "+asientosPeticion+" asientos.");
        if (asientosLibres>=asientosPeticion) {
            try {
                Thread.sleep(2000);
                System.out.println("Se han reservado "+asientosPeticion+" asientos.");
                asientosLibres=asientosLibres-asientosPeticion;
                System.out.println("Quedan "+asientosLibres+" libres");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Logger.getLogger(AsientosAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("No quedan asientos suficientes");
        }
        
    }
    
}
