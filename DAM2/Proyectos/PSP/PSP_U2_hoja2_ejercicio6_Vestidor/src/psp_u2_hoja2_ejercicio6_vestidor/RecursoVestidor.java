/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio6_vestidor;

import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class RecursoVestidor {

    private int[] probadores = {0, 0, 0};

    public RecursoVestidor() {
    }

    public boolean lleno() {
        int contadorProbadores = 0;
        for (int probador : probadores) {
            if (probador != 0) {
                contadorProbadores++;
            }
        }
        if (contadorProbadores == 3) {
            return true;
        } else {
            return false;
        }
    }

    public int posicionLibre() {
        for (int i = 0; i < probadores.length; i++) {
            if (probadores[i] == 0) {
                return i;
            }

        }
        return -1;
    }

    public synchronized void entrar(int id) {
        while (lleno()) {
            System.out.println("Persona "+id+" esperando a que se libere el probador ");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(RecursoVestidor.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        int probadorLibre=posicionLibre();
        if (probadorLibre>=0) {
            probadores[probadorLibre]=id;
            System.out.println("Persona "+id+" entra en el probador "+probadorLibre);
        }
    }

    public synchronized void salir(int id) {
        for (int i = 0; i < probadores.length; i++) {
            if (probadores[i] == id) {
                probadores[i] = 0;
                System.out.println("Persona " + id + " sale del probador " + i);
                notifyAll();
                break;
            }
        }
    }

}
