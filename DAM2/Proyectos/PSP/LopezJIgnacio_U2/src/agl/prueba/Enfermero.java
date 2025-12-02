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
public class Enfermero extends Thread {

    private int id_enfermero;
    private SalaSuministros salaSuministros;
    private int numCurados;

    public Enfermero(int id_enfermero, SalaSuministros salaSuministros) {
        this.id_enfermero = id_enfermero;
        this.salaSuministros = salaSuministros;
        this.numCurados = 0;
    }

    public int getId_enfermero() {
        return id_enfermero;
    }

    public int getNumCurados() {
        return numCurados;
    }

    @Override
    public void run() {

        for (int i = 0; i < 6; i++) {
            salaSuministros.curar(id_enfermero);
            numCurados++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enfermero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
