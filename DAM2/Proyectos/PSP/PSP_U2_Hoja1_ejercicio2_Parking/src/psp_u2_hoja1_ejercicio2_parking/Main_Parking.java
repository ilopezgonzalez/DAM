/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_hoja1_ejercicio2_parking;

import java.util.ArrayList;

/**
 *
 * @author damt209
 */
public class Main_Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recurso_Parking parking = new Recurso_Parking();
        //Como se necesita controlar los hilos se meten en un arrayList
        ArrayList<Thread> hilosEntran = new ArrayList();
        ArrayList<Thread> hilosSalen = new ArrayList();
        //Entra 25 coches, por lo que se itera 25 veces.
        for (int i = 0; i < 25; i++) {
            //Se crea un nuevo hilo con la clase que tenemos creada que extiende Thread
            Thread hiloEntra = new Entra_Parking(("Entra " + i), parking);
            //Se lanza el hilo.
            hiloEntra.start();
            //Se mete el hilo en el ArrayList.
            hilosEntran.add(hiloEntra);

        }
        //Salen 20 coches, por lo que se itera 20 veces.
        for (int i = 0; i < 20; i++) {
            //Se crea el  nuevo hilo.
            Thread hiloSale = new Sale_Parking(("Sale " + i), parking);
            //Se inicia el nuevo hilo.
            hiloSale.start();
            //Se mete el hilo en el ArrayList.
            hilosSalen.add(hiloSale);
        }

        try {
            
            for (Thread hilo : hilosEntran) {
                hilo.join();
            }
            for (Thread hilo : hilosSalen) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Numero total de coches en el parking: " + parking.getCuenta());
    }

}
