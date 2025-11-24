/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_hoja2_ejercicio3_parking_limite;

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
        
        //Se debe crear el recurso parking para poder nombrar los hilos y adjuntarlos al parking
        Recurso_Parking parking = new Recurso_Parking();
        //Como se necesita controlar los hilos se meten en un arrayList
        ArrayList<Thread> hilosEntran = new ArrayList();
        ArrayList<Thread> hilosSalen = new ArrayList();
        
        //Salen 5 coches, por lo que se itera 5 veces.
        for (int i = 0; i < 5; i++) {
            //Se crea el  nuevo hilo con nombre ("Sale "+i)
            Thread hiloSale = new Sale_Parking(("Sale " + i), parking);
            //Se inicia el nuevo hilo.
            hiloSale.start();
            //Se mete el hilo en el ArrayList.
            hilosSalen.add(hiloSale);
        }
        
        //Entra 10 coches, por lo que se itera 10 veces.
        for (int i = 0; i < 10; i++) {
            //Se crea un nuevo hilo con la clase que tenemos creada que extiende Thread, se nombra como ("Entra "+i)
            Thread hiloEntra = new Entra_Parking(("Entra " + i), parking);
            //Se lanza el hilo.
            hiloEntra.start();
            //Se mete el hilo en el ArrayList.
            hilosEntran.add(hiloEntra);

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
