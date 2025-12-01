/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio6_vestidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class HiloPersona extends Thread {

    private int idPersona;
    private RecursoVestidor vestidor;

    public HiloPersona(int idPersona, RecursoVestidor vestidor) {
        this.idPersona = idPersona;
        this.vestidor = vestidor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                vestidor.entrar(idPersona);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPersona.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
                return;
            }
            vestidor.salir(idPersona);
        }

    }

}
