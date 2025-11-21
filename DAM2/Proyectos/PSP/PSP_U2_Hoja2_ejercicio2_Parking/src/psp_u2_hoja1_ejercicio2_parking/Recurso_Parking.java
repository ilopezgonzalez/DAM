/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja1_ejercicio2_parking;

/**
 *
 * @author damt209
 */
public class Recurso_Parking {
    
    private int cuenta;

    public Recurso_Parking() {
        //El parking tiene incialmente 30 coches
        this.cuenta = 30;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    
    public synchronized void incrementaCuenta(){
        System.out.println("Coche "+Thread.currentThread().getName()+" entra al parking");
        cuenta++;
        System.out.println("Coche "+Thread.currentThread().getName()+", hay "+cuenta+" coches en total");
    }
    
    public synchronized void decrementaCuenta(){
        System.out.println("Coche "+Thread.currentThread().getName()+" sale del parking");
        cuenta--;
        System.out.println("Coche "+Thread.currentThread().getName()+", hay "+cuenta+" coches en total");
    }
    
}
