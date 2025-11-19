/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja1_ejercicio2_parking;

/**
 *
 * @author damt209
 */
public class Sale_Parking extends Thread{
    
    private Recurso_Parking parking;

    public Sale_Parking(String nombre, Recurso_Parking parking) {
        this.setName(nombre);
        this.parking = parking;
    }
    
    @Override
    public void run(){
        parking.decrementaCuenta();
    }
    
    
}
