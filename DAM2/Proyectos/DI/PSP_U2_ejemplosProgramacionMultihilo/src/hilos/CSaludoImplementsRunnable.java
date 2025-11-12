/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;


public class CSaludoImplementsRunnable implements Runnable {

    //clase que implementa a Runnable
    @Override
    public void run() {
        //se redefine el método run()con el código asociado al hilo
        System.out.println("¡Saludo desde un hilo creado con Runnable!");
    }

    public static void main(String args[]) {

        CSaludoImplementsRunnable miRunnable = new CSaludoImplementsRunnable();
        //se crea un objeto  Saludo
        Thread hilo1 = new Thread(miRunnable);
        //se crea un objeto Thread (el hilo hilo1) pasando como argumento
        // al constructor un objeto Saludo
        hilo1.start();
        //se invoca al método start() del hilo hilo1
    }
}
