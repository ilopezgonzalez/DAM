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
public class HiloCorredor extends Thread{
    
    private int idCorredor;
    private Carrera carrera;

    public HiloCorredor(int idCorredor, Carrera carrera) {
        this.idCorredor = idCorredor;
        this.carrera = carrera;
    }

    @Override
    public void run() {
        carrera.iniciarCarrera(idCorredor);
    }
      
}
