/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_preparacion_boxlavado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class HiloCoche extends Thread {

    private int id_coche;
    private Taller taller;

    public HiloCoche(int id_coche, Taller taller) {
        this.id_coche = id_coche;
        this.taller = taller;
    }

    @Override
    public void run() {
        try {
            taller.entrar(id_coche);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCoche.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
            return;
        }
        taller.salir(id_coche);
    }

}
