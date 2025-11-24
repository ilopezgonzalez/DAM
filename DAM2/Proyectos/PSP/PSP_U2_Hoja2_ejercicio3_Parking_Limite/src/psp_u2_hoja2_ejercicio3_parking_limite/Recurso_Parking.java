/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio3_parking_limite;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class Recurso_Parking {

    private int cuenta;
    private int limite;

    public Recurso_Parking() {
        this.cuenta = 5;
        this.limite = 10;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    
    

    public synchronized void incrementaCuenta() {
        while (cuenta == limite) {       // IMPORTANTE: while, no if
            try {
                System.out.println("El coche " + Thread.currentThread().getName() +" espera porque el parking está lleno. (" + cuenta + ")");
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Cuando sale del while significa que HAY HUECO
        cuenta++;
        System.out.println("Coche " + Thread.currentThread().getName() +
            " entra. Coches actuales: " + cuenta);

        notifyAll(); // Puede despertar hilos que esperan para salir o entrar
    }

    public synchronized void decrementaCuenta() {
        while (cuenta == 0) {            // EVITA valores negativos
            try {
                System.out.println("El coche " + Thread.currentThread().getName() +
                    " espera porque el parking está vacío.");
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        cuenta--;
        System.out.println("Coche " + Thread.currentThread().getName() +
            " sale. Coches actuales: " + cuenta);

        notifyAll(); // Despierta posibles hilos esperando para entrar
    }
}
