/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agl.prueba;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class Doctora extends Thread{
    
    private int id_doctor;
    private SalaSuministros salaSuministros;
    private int kitsCreados=0;

    public Doctora(int id_doctor, SalaSuministros salaSuministros) {
        this.id_doctor = id_doctor;
        this.salaSuministros = salaSuministros;
    }

    @Override
    public void run() {
        while (kitsCreados<=5) {
            salaSuministros.prepararKit(id_doctor);
            kitsCreados++;
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(Doctora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
}
