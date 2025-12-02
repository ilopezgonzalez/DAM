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
public class SalaSuministros {

    int[] compartimentos = {0, 0, 0};

    private final int NUM_COMPARTIMENTOS_MAX = 3;
    private int numCompartimentosOcupados = 0;

    private final int PACIENTES_TOTAL = 6;
    private int contadorCurados = 0;

    public SalaSuministros() {
    }

    public int getContadorCurados() {
        return contadorCurados;
    }

    public synchronized boolean lleno() {
        int contadorCompartimentos = 0;
        for (int compartimento : compartimentos) {
            if (compartimento != 0) {
                contadorCompartimentos++;
            }
        }
        if (contadorCompartimentos == 3) {
            return true;
        } else {
            return false;
        }

    }

    public synchronized int compartimentoLibre() {
        for (int i = 0; i < compartimentos.length; i++) {
            if (compartimentos[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void prepararKit(int id) {
        while (lleno()) {
            System.out.println("El doctor " + id + " no puede preparar kits porque todos los compartimentos estan llenos");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalaSuministros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int numCompartimentoLibre = compartimentoLibre();
        if (numCompartimentoLibre >= 0) {
            compartimentos[numCompartimentoLibre] = 1;
            System.out.println("Doctor " + id + " prepara kit de emergencia");
            numCompartimentosOcupados++;
            System.out.println("Doctor " + id + " compartimentos libres " + (NUM_COMPARTIMENTOS_MAX - numCompartimentosOcupados));
        }

    }

    public synchronized void curar(int id) {
        while (numCompartimentosOcupados == 0) {
            System.out.println("Enfermero " + id + " debe esperar, no hay kits");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalaSuministros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < compartimentos.length; i++) {
            if (compartimentos[i] == 1) {
                compartimentos[i] = 0;
                numCompartimentosOcupados--;
                System.out.println("Enfermero " + id + " usa kit en sala de suministros");
                contadorCurados++;
                System.out.println("Enfermero " + id + " pacientes pendientes de atender " + (PACIENTES_TOTAL - contadorCurados));
                System.out.println("Enfermero " + id + " compartimentos libres " + (NUM_COMPARTIMENTOS_MAX - numCompartimentosOcupados));
            }
            if (contadorCurados != 6) {
                notifyAll();
            } else {
                System.out.println("Todos los pacientes criticos han sido tratados.");
                break;

            }

        }
    }

}
