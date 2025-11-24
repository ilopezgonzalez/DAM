/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio3_parking_limite;

/**
 *
 * @author damt209
 */
public class Entra_Parking extends Thread{
    //Se crea una objeto Recurso_Parking para poder sacar sus metodos
    private Recurso_Parking parking;

    public Entra_Parking(String nombre, Recurso_Parking parking) {
        //Este setName() nombra al hilo que se está ejecutando
        this.setName(nombre);
        this.parking = parking;
    }
    
    @Override
    public void run(){
        parking.incrementaCuenta();
    }
    
    
    
}
